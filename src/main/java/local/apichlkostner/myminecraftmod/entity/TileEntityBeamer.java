package local.apichlkostner.myminecraftmod.entity;

import java.util.List;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.network.MessagePlayerBeam;
import local.apichlkostner.myminecraftmod.network.NetworkHandler;
import local.apichlkostner.myminecraftmod.network.TileEntityDescriptionHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;


public class TileEntityBeamer extends TileEntity implements ITileEntityDescriptionWrapper {

	private ChunkCoordinates beamCoordinates;
	private boolean beamCoordinatesSet;

	private int beamTimer;

	public TileEntityBeamer() {
		super();
		beamCoordinates = new ChunkCoordinates();
		beamCoordinatesSet = false;
	}

	@Override
	public void updateEntity(){
		List<Entity> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class,
				AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 2, zCoord + 1));

		if (entities.isEmpty()) {
			beamTimer = Constants.BeamTime;
		} else {
			if (beamTimer == 1) {
				for(Entity entity : entities) {
					beamPlayer((EntityPlayer)entity); 
				}

			}
			if (beamTimer > 0)
				beamTimer--;
		}


	}

	@Override
	public Packet getDescriptionPacket(){
		ByteBuf buf = Unpooled.buffer();
		buf.writeInt(xCoord);
		buf.writeInt(yCoord);
		buf.writeInt(zCoord);
		writeToPacket(buf);
		return new FMLProxyPacket(buf, TileEntityDescriptionHandler.CHANNEL);
	}


	public void writeToPacket(ByteBuf buf){
		buf.writeInt(beamCoordinates.posX);
		buf.writeInt(beamCoordinates.posY);
		buf.writeInt(beamCoordinates.posZ);
		buf.writeBoolean(beamCoordinatesSet);
	}


	public void readFromPacket(ByteBuf buf){
		beamCoordinates.posX = buf.readInt();
		beamCoordinates.posY = buf.readInt();
		beamCoordinates.posZ = buf.readInt();
		beamCoordinatesSet   = buf.readBoolean();
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		beamCoordinates.posX = tag.getInteger("beamX");
		beamCoordinates.posY = tag.getInteger("beamY");
		beamCoordinates.posZ = tag.getInteger("beamZ");
		beamCoordinatesSet   = tag.getBoolean("coordinatesSet");

	}

	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		tag.setInteger("beamX", beamCoordinates.posX);
		tag.setInteger("beamY", beamCoordinates.posY);
		tag.setInteger("beamZ", beamCoordinates.posZ);
		tag.setBoolean("coordinatesSet", beamCoordinatesSet);
	}

	public void setBeamCoordinates(int x, int y, int z) {
		beamCoordinates.posX = x;
		beamCoordinates.posY = y;
		beamCoordinates.posZ = z;
		beamCoordinatesSet = true;
	}

	public void setPlayerOnBeamer(EntityPlayer player) {

	}

	public void beamPlayer(EntityPlayer player) {
		if (beamCoordinatesSet) {
			// beamer on beam location still available
			if (player.worldObj.getTileEntity(beamCoordinates.posX, beamCoordinates.posY, beamCoordinates.posZ) instanceof TileEntityBeamer) {
				// there is enough space for the player at the beam location
				if (player.worldObj.isAirBlock(beamCoordinates.posX, beamCoordinates.posY + 1, beamCoordinates.posZ)
						&& player.worldObj.isAirBlock(beamCoordinates.posX, beamCoordinates.posY + 2, beamCoordinates.posZ)) {
					player.setPosition(beamCoordinates.posX + 0.5, beamCoordinates.posY + 1 + player.yOffset, beamCoordinates.posZ + 0.5);
				}
			}
		}
	}
}

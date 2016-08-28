package local.apichlkostner.myminecraftmod.entity;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.network.MessagePlayerBeam;
import local.apichlkostner.myminecraftmod.network.NetworkHandler;
import local.apichlkostner.myminecraftmod.network.TileEntityBeamerInit;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;


public class TileEntityBeamer extends TileEntity {

	private ChunkCoordinates beamCoordinates;
	private boolean beamCoordinatesSet;

	public TileEntityBeamer() {
		super();
		beamCoordinates = new ChunkCoordinates();
		beamCoordinatesSet = false;
	}

	@Override
	public Packet getDescriptionPacket(){
		ByteBuf buf = Unpooled.buffer();
		buf.writeInt(xCoord);
		buf.writeInt(yCoord);
		buf.writeInt(zCoord);
		writeToPacket(buf);
		return new FMLProxyPacket(buf, Constants.CHANNEL);
	}


	public void writeToPacket(ByteBuf buf){
		ByteBufUtils.writeVarInt(buf, beamCoordinates.posX, 100000);
		ByteBufUtils.writeVarInt(buf, beamCoordinates.posY, 100000);
		ByteBufUtils.writeVarInt(buf, beamCoordinates.posZ, 100000);
	}


	public void readFromPacket(ByteBuf buf){
		beamCoordinates.posX = ByteBufUtils.readVarInt(buf, 10000);
		beamCoordinates.posY = ByteBufUtils.readVarInt(buf, 10000);
		beamCoordinates.posZ = ByteBufUtils.readVarInt(buf, 10000);

		//worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
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

	public void beamPlayer(EntityPlayer player) {
		if (!player.worldObj.isRemote && beamCoordinatesSet){
			player.setPosition(beamCoordinates.posX + 0.5, beamCoordinates.posY + 1 + player.yOffset, beamCoordinates.posZ + 0.5);
			
			NetworkHandler.INSTANCE.sendToAll(
					new MessagePlayerBeam(beamCoordinates.posX + 0.5f, 
							beamCoordinates.posY + 1f + player.yOffset, 
							beamCoordinates.posZ + 0.5f));
			/*NetworkHandler.INSTANCE.sendToAll(
					new MessagePlayerBeam(player.posX, player.posY, player.posZ));*/
		}
		/*
		NetworkHandler.INSTANCE.sendToAll(
				new MessagePlayerBeam(beamCoordinates.posX + 0.5f, 
						beamCoordinates.posY + 1f + player.yOffset, 
						beamCoordinates.posZ + 0.5f));*/
	}
}

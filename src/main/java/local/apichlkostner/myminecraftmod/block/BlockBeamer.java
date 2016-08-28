package local.apichlkostner.myminecraftmod.block;

import java.util.LinkedList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.entity.TileEntityBeamer;
import local.apichlkostner.myminecraftmod.item.ItemBeamKey;
import local.apichlkostner.myminecraftmod.network.NetworkHandler;
import local.apichlkostner.myminecraftmod.network.TileEntityBeamerInit;
import local.apichlkostner.myminecraftmod.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class BlockBeamer extends BlockContainer implements IBlock {

	public BlockBeamer(Material material) {
		super(material);
	}

	@Override
	public void init() {
		setCreativeTab(CreativeTabs.tabAllSearch);
		setBlockName(Constants.BlockBeamerName);
		setBlockTextureName(Constants.BlockBeamerTexture);
		GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		ItemStack playerItem = player.getCurrentEquippedItem();
		
		if (playerItem != null && playerItem.getItem() instanceof ItemBeamKey) {
			NBTTagCompound c = playerItem.getTagCompound();
			if (c != null) {
				if (!c.hasKey("posX")) {
					c.setInteger("posX", x);
					c.setInteger("posY", y);
					c.setInteger("posZ", z);
				}
				TileEntityBeamer tileEntity = (TileEntityBeamer)world.getTileEntity(x, y, z);
				tileEntity.setBeamCoordinates(c.getInteger("posX"), c.getInteger("posY"), c.getInteger("posZ"));
			} else {
				c = new NBTTagCompound();
				c.setInteger("posX", x);
				c.setInteger("posY", y);
				c.setInteger("posZ", z);
				playerItem.setTagCompound(c);
			}
		} else {
			TileEntityBeamer tileEntity = (TileEntityBeamer)world.getTileEntity(x, y, z);
			if (tileEntity != null)
				tileEntity.beamPlayer(player);
		}
		
		return true;
	}

	

	@Override
	public TileEntity createNewTileEntity(World world, int data) {
		return new TileEntityBeamer();
	}
}

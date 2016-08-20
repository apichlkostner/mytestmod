package local.apichlkostner.myminecraftmod.block;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTable extends Block implements IBlock {

	public BlockTable(Material material) {
		super(material);
	}

	@Override
	public void init() {
		setCreativeTab(CreativeTabs.tabAllSearch);
		setBlockName(Constants.BlockTableName);
		setBlockTextureName(Constants.BlockTableTexture);
		GameRegistry.registerBlock(this, getUnlocalizedName().substring(5));
	}

}

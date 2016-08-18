package local.apichlkostner.myminecraftmod.block;

import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTable extends MyModBlock {

	public BlockTable(Material material) {
		super(material);
	}

	@Override
	public void init() {
		setBlockName(Constants.BlockTableName);
		setCreativeTab(CreativeTabs.tabAllSearch);		
		setBlockTextureName(Constants.BlockTableTexture);
	}

}

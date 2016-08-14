package block;

import config.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTable extends MyModBlock {

	public BlockTable(Material material) {
		super(material);
	}

	@Override
	public void init() {
		setCreativeTab(CreativeTabs.tabAllSearch);
		setBlockName(Constants.BlockTableName);
		setBlockTextureName(Constants.BlockTableTexture);
	}

}

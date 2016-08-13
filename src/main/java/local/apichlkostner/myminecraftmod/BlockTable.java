package local.apichlkostner.myminecraftmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTable extends Block {

	protected BlockTable(Material material) {
		super(material);
		setCreativeTab(CreativeTabs.tabAllSearch);
		setBlockName(Constants.BlockTableName);
		setBlockTextureName(Constants.BlockTableTexture);
	}

}

package local.apichlkostner.myminecraftmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class MyModBlock extends Block implements IBlock {

	protected MyModBlock(Material material) {
		super(material);
	}
	
}

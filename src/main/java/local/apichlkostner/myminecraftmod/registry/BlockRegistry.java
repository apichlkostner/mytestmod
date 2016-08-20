package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.block.BlockTable;
import local.apichlkostner.myminecraftmod.block.IBlock;
import local.apichlkostner.myminecraftmod.config.Constants;

public class BlockRegistry {
	public static final IBlock blockTable = new BlockTable(Constants.BlockTableMaterial);
	public static final IBlock[] blocks = {
			blockTable
	};
}

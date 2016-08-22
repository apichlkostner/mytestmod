package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.block.BlockBeamer;
import local.apichlkostner.myminecraftmod.block.IBlock;
import local.apichlkostner.myminecraftmod.config.Constants;

public class BlockRegistry {
	public static final IBlock blockTable = new BlockBeamer(Constants.BlockTableMaterial);
	public static final IBlock[] blocks = {
			blockTable
	};
}

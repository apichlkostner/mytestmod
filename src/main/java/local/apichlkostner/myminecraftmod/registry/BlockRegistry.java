package local.apichlkostner.myminecraftmod.registry;

import local.apichlkostner.myminecraftmod.block.BlockTable;
import local.apichlkostner.myminecraftmod.block.MyModBlock;
import local.apichlkostner.myminecraftmod.config.Constants;

public class BlockRegistry {
	public static final MyModBlock blockTable = new BlockTable(Constants.BlockTableMaterial);
	public static final MyModBlock[] blocks = {
			blockTable
	};
}

package local.apichlkostner.myminecraftmod.registry;

import block.BlockTable;
import block.MyModBlock;
import config.Constants;

public class BlockRegistry {
	public static final MyModBlock blockTable = new BlockTable(Constants.BlockTableMaterial);
	public static final MyModBlock[] blocks = {
			blockTable
	};
}

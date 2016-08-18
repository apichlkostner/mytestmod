package local.apichlkostner.myminecraftmod.registry;

import java.util.ArrayList;

import local.apichlkostner.myminecraftmod.block.BlockTable;
import local.apichlkostner.myminecraftmod.block.MyModBlock;
import local.apichlkostner.myminecraftmod.config.Constants;

public class BlockRegistry {
	public static BlockRegistry instance;
	
	public MyModBlock blockTable = new BlockTable(Constants.BlockTableMaterial);
	
	public ArrayList<MyModBlock> blocks;
	
	public static BlockRegistry getInstance() {
		if (instance == null) {
			instance = new BlockRegistry();
		}
		
		return instance;
	}
	
	public void register(MyModBlock modBlock) {
		blocks.add(modBlock);
	}
	
	
	private BlockRegistry() {
		blocks = new ArrayList<MyModBlock>();
		blocks.add(blockTable);
	}
}

package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Baguette extends ItemFood implements IItem {

	public Baguette() {
		super(20, 1.0f, false);
		
	}
	
	@Override
	public void init() {
		setUnlocalizedName(Constants.BaguetteName);
		setTextureName(Constants.BaguetteTexture);
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	
	@Override
	public void registerReceipe() {
		ItemStack stackBaguette = new ItemStack(this);		
		
		GameRegistry.addSmelting((Item)ItemRegistry.baguetteRaw, stackBaguette, 10f);
	}

}

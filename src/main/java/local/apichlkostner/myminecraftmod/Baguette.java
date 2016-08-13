package local.apichlkostner.myminecraftmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Baguette extends ItemFood {

	public Baguette() {
		super(20, 1.0f, false);
		setUnlocalizedName("Baguette");
		setTextureName("mymod:baguette");
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	
	public void registerReceipe(Item base) {
		ItemStack stackBaguette = new ItemStack(this);		
		
		GameRegistry.addSmelting(base, stackBaguette, 10f);
	}

}

package local.apichlkostner.myminecraftmod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;


public class BaguetteRaw extends ItemFood {
	public BaguetteRaw() {
		super(20, 0.1f, false);
		setUnlocalizedName("BaguetteRaw");
		setTextureName("mymod:baguetteraw");
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
	
	public void registerReceipe() {
		ItemStack stackBaguetteRaw = new ItemStack(this);
		
		GameRegistry.addRecipe(stackBaguetteRaw, new Object[]{"  w", " w ", "w  ",
				'w', Items.wheat});
	}
}

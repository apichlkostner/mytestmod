package local.apichlkostner.myminecraftmod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.registry.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSteelArmor extends ItemArmor implements IItem {
	private static final String[][] receipe = {
			{"sss", "s s", "   "},			// helmet
			{"s s", "sss", "sss"},			// plate
			{"sss", "s s", "s s"},			// leggings
			{"   ", "s s", "s s"}			// boots
	};
	
	
	public ItemSteelArmor(ArmorMaterial material, int renderIndex, int type) {
		super(material, renderIndex, type);
	}

	@Override
	public void init() {
		setUnlocalizedName(Constants.ItemSteelArmorName[armorType]);
		setTextureName(Constants.ItemSteelArmorTexture[armorType]);
		setCreativeTab(CreativeTabs.tabAllSearch);
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
	}

	@Override
	public void registerReceipe() {
		ItemStack stackSteelArmor = new ItemStack(this);
		//GameRegistry.addRecipe(stackSteelArmor, receipe[0]);
		GameRegistry.addRecipe(stackSteelArmor, new Object[]{receipe[armorType], 's', ItemRegistry.itemSteelIngot});
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		int ret = (armorType == 2) ? 1 : 0;
		
		return Constants.ItemSteelArmorModel[ret];
	}

}

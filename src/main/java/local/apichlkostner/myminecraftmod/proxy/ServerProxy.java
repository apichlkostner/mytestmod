package local.apichlkostner.myminecraftmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy {
	public void registerRenderInfo() {
		
	}
	
	public EntityPlayer getPlayerClientSide() {
		// no client side player on server side
		return null;
	}
}

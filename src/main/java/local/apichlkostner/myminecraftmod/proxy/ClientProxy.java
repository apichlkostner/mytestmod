package local.apichlkostner.myminecraftmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {
	public void registerRenderInfo() {
		
	}
	
	@Override
	public EntityPlayer getPlayerClientSide() {
		return Minecraft.getMinecraft().thePlayer;
	}
}

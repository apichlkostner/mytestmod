package local.apichlkostner.myminecraftmod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public interface IProxy {
	public void registerRenderInfo();
	public abstract EntityPlayer getPlayerClientSide();
}

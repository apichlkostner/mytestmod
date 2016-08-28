package local.apichlkostner.myminecraftmod.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import local.apichlkostner.myminecraftmod.config.Constants;
import net.minecraft.entity.player.EntityPlayerMP;

public class NetworkHandler{
    public static SimpleNetworkWrapper INSTANCE;

    public static void init(){
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MODID);
        
        INSTANCE.registerMessage(MessagePlayerBeam.class, MessagePlayerBeam.class, 0, Side.CLIENT);
        INSTANCE.registerMessage(TileEntityBeamerInit.class, TileEntityBeamerInit.class, 1, Side.CLIENT);
        INSTANCE.registerMessage(TileEntityBeamerInit.class, TileEntityBeamerInit.class, 2, Side.SERVER);
    }   
}

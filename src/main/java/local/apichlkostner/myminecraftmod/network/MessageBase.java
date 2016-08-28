package local.apichlkostner.myminecraftmod.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>{

    @Override
    public REQ onMessage(REQ message, MessageContext ctx){
        if(ctx.side == Side.SERVER) {
        	handleServerMessage(message, ctx.getServerHandler().playerEntity);
        } else {
        	handleClientMessage(message, Minecraft.getMinecraft().thePlayer);
        }
        return null;
    }

    /**
     * Message handler on server side
     */
    public abstract void handleClientMessage(REQ message, EntityPlayer player);

    /**
     * Message handler on client side
     */
    public abstract void handleServerMessage(REQ message, EntityPlayer player);
}

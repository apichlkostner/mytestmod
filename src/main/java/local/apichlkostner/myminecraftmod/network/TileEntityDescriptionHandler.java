package local.apichlkostner.myminecraftmod.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;
import local.apichlkostner.myminecraftmod.MyMod;
import local.apichlkostner.myminecraftmod.config.Constants;
import local.apichlkostner.myminecraftmod.entity.ITileEntityDescriptionWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

@Sharable
public class TileEntityDescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>{
    public static final String CHANNEL = Constants.MODID + "Description";

    public static void init(){
    	NetworkRegistry.INSTANCE.newChannel(CHANNEL, new TileEntityDescriptionHandler());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception{
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = MyMod.proxy.getPlayerClientSide().worldObj.getTileEntity(x, y, z);
        if(te instanceof ITileEntityDescriptionWrapper) {
            ((ITileEntityDescriptionWrapper)te).readFromPacket(buf);
        }
    }

}
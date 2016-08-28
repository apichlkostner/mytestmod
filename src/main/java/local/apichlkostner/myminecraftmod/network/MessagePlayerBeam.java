package local.apichlkostner.myminecraftmod.network;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessagePlayerBeam extends MessageBase<MessagePlayerBeam>{
	private float x, y, z;

	public MessagePlayerBeam(){}

	public MessagePlayerBeam(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void fromBytes(ByteBuf buf){
		x = buf.readFloat();
		y = buf.readFloat();
		z = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeFloat(x);
		buf.writeFloat(y);
		buf.writeFloat(z);
	}

	@Override
	public void handleClientMessage(MessagePlayerBeam message, EntityPlayer player){
		player.setPosition(message.x,  message.y,  message.z);
	}

	@Override
	public void handleServerMessage(MessagePlayerBeam message, EntityPlayer player){
	}

}
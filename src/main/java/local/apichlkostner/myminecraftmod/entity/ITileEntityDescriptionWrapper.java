package local.apichlkostner.myminecraftmod.entity;

import io.netty.buffer.ByteBuf;

public interface ITileEntityDescriptionWrapper {	
	public void writeToPacket(ByteBuf buf);
	public void readFromPacket(ByteBuf buf);
}

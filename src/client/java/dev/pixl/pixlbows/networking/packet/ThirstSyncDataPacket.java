package dev.pixl.pixlbows.networking.packet;

import dev.pixl.pixlbows.util.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class ThirstSyncDataPacket
{
	public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
	                           PacketByteBuf buf, PacketSender responseSender)
	{
		assert client.player != null;
		((IEntityDataSaver)client.player).getPersistentData().putInt("thirst", buf.readInt());
	}
}

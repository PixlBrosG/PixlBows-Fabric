package dev.pixl.pixlbows.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class ExamplePacket
{
	public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
	                           PacketByteBuf buf, PacketSender responseSender)
	{
		// Everything in here happens on the server
		EntityType.COW.spawn(player.getServerWorld(), null, null, player.getBlockPos(),
				SpawnReason.TRIGGERED, true, false);
	}
}

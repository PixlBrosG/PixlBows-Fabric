package dev.pixl.pixlbows.util;

import dev.pixl.pixlbows.networking.ModMessagesServer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class ThirstData
{
	public static int addThirst(IEntityDataSaver player, int amount)
	{
		NbtCompound nbt = player.getPersistentData();
		int thirst = nbt.getInt("thirst");

		thirst += amount;
		if (thirst > 10)
			thirst = 10;

		nbt.putInt("thirst", thirst);
		syncThirst(thirst, (ServerPlayerEntity) player);
		return thirst;
	}

	public static int removeThirst(IEntityDataSaver player, int amount)
	{
		NbtCompound nbt = player.getPersistentData();
		int thirst = nbt.getInt("thirst");

		thirst -= amount;
		if (thirst < 0)
			thirst = 0;

		nbt.putInt("thirst", thirst);
		syncThirst(thirst, (ServerPlayerEntity) player);
		return thirst;
	}

	public static void syncThirst(int thirst, ServerPlayerEntity player)
	{
		PacketByteBuf buffer = PacketByteBufs.create();
		buffer.writeInt(thirst);
		ServerPlayNetworking.send(player, ModMessagesServer.THIRST_SYNC_ID, buffer);
	}
}

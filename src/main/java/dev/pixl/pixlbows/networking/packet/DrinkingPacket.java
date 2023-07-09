package dev.pixl.pixlbows.networking.packet;

import dev.pixl.pixlbows.util.IEntityDataSaver;
import dev.pixl.pixlbows.util.ThirstData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class DrinkingPacket
{
	private static final String MESSAGE_DRINKING_WATER = "message.pixlbows.drank_water";
	private static final String MESSAGE_NO_WATER_NEARBY = "message.pixlbows.no_water_nearby";

	public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
	                           PacketByteBuf buf, PacketSender responseSender)
	{
		// Everything in here happens on the server
		ServerWorld world = player .getServerWorld();
		if (isWaterAroundPlayer(player, world, 2))
		{
			world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
					0.5f, world.random.nextFloat() * 0.1f + 0.9f);
			ThirstData.addThirst((IEntityDataSaver)player, 1);
		}
		else
		{
			player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY).fillStyle(
					Style.EMPTY.withColor(Formatting.RED)), false);
			ThirstData.syncThirst(((IEntityDataSaver)player).getPersistentData().getInt("thirst"), player);
		}
	}

	private static boolean isWaterAroundPlayer(ServerPlayerEntity player, ServerWorld world, int size)
	{
		return  BlockPos.stream(player.getBoundingBox().expand(size)).map(world::getBlockState)
				.filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
	}
}

package dev.pixl.pixlbows.event;

import dev.pixl.pixlbows.util.IEntityDataSaver;
import dev.pixl.pixlbows.util.ThirstData;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Random;

public class PlayerTickHandler implements ServerTickEvents.StartTick
{
	public static final String MESSAGE_REMOVED_THIRST = "message.pixlbows.removed_thirst";

	private static final Random RANDOM = new Random();

	@Override
	public void onStartTick(MinecraftServer server)
	{
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
		{
			if (!player.isCreative() && RANDOM.nextFloat() <= 0.005f)
			{
				IEntityDataSaver dataPlayer = (IEntityDataSaver)player;
				ThirstData.removeThirst(dataPlayer, 1);
			}
		}
	}
}

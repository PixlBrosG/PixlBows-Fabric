package dev.pixl.pixlbows.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.Arrays;

public class HudOverlay
{
	public static void render(DrawContext drawContext, float tickDelta)
	{
		MinecraftClient client = MinecraftClient.getInstance();

		drawContext.drawText(client.textRenderer, client.getCurrentFps() + " fps", 5, 5, 0xffffffff, true);

		if (client.getServer() != null)
		{
			long[] lastTickLengths = client.getServer().lastTickLengths;
			long averageTickLength = Arrays.stream(lastTickLengths).sum() / lastTickLengths.length / 1000000;

			int tps = Math.round(Math.min(1000.0f / averageTickLength, 20.0f));

			drawContext.drawText(client.textRenderer, tps + " TPS", 5, 15, 0xffffffff, true);
			drawContext.drawText(client.textRenderer, averageTickLength + " ms/T", 5, 25, 0xffffffff, true);
		}
	}
}

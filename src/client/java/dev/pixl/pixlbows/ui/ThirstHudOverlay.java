package dev.pixl.pixlbows.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class ThirstHudOverlay
{
	private static final Identifier FILLED_THIRST = new Identifier(PixlBows.MOD_ID, "textures/thirst/filled_thirst.png");
	private static final Identifier EMPTY_THIRST = new Identifier(PixlBows.MOD_ID, "textures/thirst/empty_thirst.png");

	public static void render(DrawContext drawContext, float tickDelta)
	{
		MinecraftClient client = MinecraftClient.getInstance();
		if (client == null || client.player == null)
			return;

		if (client.player.isCreative())
			return;

		int x = 0, y = 0;

		int width = client.getWindow().getScaledWidth();
		int height = client.getWindow().getScaledHeight();

		x = width / 2;
		y = height;

		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		drawContext.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

		int thirst = ((IEntityDataSaver)client.player).getPersistentData().getInt("thirst");
		for (int i = 0; i < thirst; ++i)
		{
			drawContext.drawTexture(FILLED_THIRST, x + 10 + (i * 8), y - 50,
					0, 0, 8, 8, 8, 8);
		}

		for (int i = thirst; i < 10; ++i)
		{
			drawContext.drawTexture(EMPTY_THIRST, x + 10 + (i * 8), y - 50,
					0, 0, 8, 8, 8, 8);
		}
	}
}

package dev.pixl.pixlbows;

import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.item.custom.EightBallItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PixlBowsClient implements ClientModInitializer
{
	private void registerEventHandlers()
	{
		ItemTooltipCallback.EVENT.register((stack, context, lines) ->
		{
			Item item = stack.getItem();
			if (item instanceof EightBallItem)
			{
				if (Screen.hasShiftDown())
					lines.add((Text.translatable("tooltip." + PixlBows.MOD_ID + ".eight_ball.shift").formatted(Formatting.AQUA)));
				else
					lines.add(Text.translatable("tooltip." + PixlBows.MOD_ID + ".eight_ball").formatted(Formatting.YELLOW));
			}
		});
	}

	@Override
	public void onInitializeClient()
	{
		registerEventHandlers();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());
	}
}
package dev.pixl.pixlbows;

import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.event.KeyInputHandler;
import dev.pixl.pixlbows.fluid.ModFluids;
import dev.pixl.pixlbows.item.custom.EightBallItem;
import dev.pixl.pixlbows.networking.ModMessagesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

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

		KeyInputHandler.register();
	}

	@Override
	public void onInitializeClient()
	{
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
				new SimpleFluidRenderHandler(
						new Identifier("minecraft:block/water_still"),
						new Identifier("minecraft:block/water_flow"),
						0xA1E038D3
				));

		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
				ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

		registerEventHandlers();
		ModMessagesClient.registerPackets();
	}
}
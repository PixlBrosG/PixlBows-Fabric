package dev.pixl.pixlbows.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler
{
	public static final String KEY_CATEGORY_PIXLBOWS = "key.category.pixlbows.pixlbows";
	public static final String KEY_DRINK_WATER = "key.pixlbows.drink_water";

	public static KeyBinding drinkingKey;

	private static void registerKeyInputs()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client ->
		{
			if (drinkingKey.wasPressed())
			{
				if (client.player != null)
					client.player.sendMessage(Text.literal("Pressed key '" + drinkingKey.getBoundKeyLocalizedText().getString() + "'"));
			}
		});
	}

	public static void register()
	{
		drinkingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				KEY_DRINK_WATER,
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_O,
				KEY_CATEGORY_PIXLBOWS
		));

		registerKeyInputs();
	}
}
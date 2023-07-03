package dev.pixl.pixlbows.items;

import dev.pixl.pixlbows.PixlBows;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
	public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
			new Item(new FabricItemSettings()));

	public static final Item TANZANITE = registerItem("tanzanite",
			new Item(new FabricItemSettings()));

	private static Item registerItem(String name, Item item)
	{
		return Registry.register(Registries.ITEM, new Identifier(PixlBows.MOD_ID, name), item);
	}

	public static void registerModItems()
	{
		PixlBows.LOGGER.debug("Registering Mod Items for " + PixlBows.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ModItemGroups.TANZANITE).register(entries ->
		{
			entries.add(RAW_TANZANITE);
			entries.add(TANZANITE);
		});
	}
}
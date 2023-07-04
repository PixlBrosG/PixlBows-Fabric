package dev.pixl.pixlbows.item;

import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.item.custom.EightBallItem;
import dev.pixl.pixlbows.item.custom.ExplosiveBowItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems
{
	public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
			new Item(new FabricItemSettings()), ModItemGroups.TANZANITE);
	public static final Item TANZANITE = registerItem("tanzanite",
			new Item(new FabricItemSettings()), ModItemGroups.TANZANITE);

	public static final Item EIGHT_BALL = registerItem("eight_ball",
			new EightBallItem(new FabricItemSettings().maxCount(1)), ModItemGroups.TANZANITE);

	public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
			new AliasedBlockItem(ModBlocks.EGGPLANT_CROP, new FabricItemSettings()), ModItemGroups.TANZANITE);
	public static final Item EGGPLANT = registerItem("eggplant",
			new Item(new FabricItemSettings().food(new FoodComponent.Builder()
					.hunger(4).saturationModifier(4).build())), ModItemGroups.TANZANITE);

	public static final Item EXPLOSIVE_BOW = registerItem("explosive_bow",
			new ExplosiveBowItem(new FabricItemSettings().maxCount(1)), ModItemGroups.BOW);

	private static Item registerItem(String name, Item item, RegistryKey<ItemGroup> tab)
	{
		Item newItem = Registry.register(Registries.ITEM, new Identifier(PixlBows.MOD_ID, name), item);
		ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(newItem));
		return newItem;
	}

	public static void registerModItems()
	{
		PixlBows.LOGGER.debug("Registering Mod Items for " + PixlBows.MOD_ID);
	}
}

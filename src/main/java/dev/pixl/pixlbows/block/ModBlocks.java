package dev.pixl.pixlbows.block;

import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlocks
{
	public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
			new Block(FabricBlockSettings.create().solid().strength(4.0f).requiresTool()), ModItemGroups.TANZANITE);

	public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
			new Block(FabricBlockSettings.create().solid().strength(4.0f).requiresTool()), ModItemGroups.TANZANITE);

	public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
			new Block(FabricBlockSettings.create().solid().strength(4.0f).requiresTool()), ModItemGroups.TANZANITE);

	public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
			new Block(FabricBlockSettings.create().solid().strength(4.0f).requiresTool()), ModItemGroups.TANZANITE);

	public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
			new Block(FabricBlockSettings.create().solid().strength(4.0f).requiresTool()), ModItemGroups.TANZANITE);

	private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> tab)
	{
		registerBlockItem(name, block, tab);
		return Registry.register(Registries.BLOCK, new Identifier(PixlBows.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> tab)
	{
		Item item = Registry.register(Registries.ITEM, new Identifier(PixlBows.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));

		ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));

		return item;
	}

	public static void registerModBlocks()
	{
		PixlBows.LOGGER.debug("Registering Mod Blocks for " + PixlBows.MOD_ID);
	}
}

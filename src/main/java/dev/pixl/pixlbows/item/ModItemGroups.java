package dev.pixl.pixlbows.item;

import dev.pixl.pixlbows.PixlBows;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
	public static final RegistryKey<ItemGroup> TANZANITE = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(PixlBows.MOD_ID, "tanzanite"));

	public static final RegistryKey<ItemGroup> BOW = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(PixlBows.MOD_ID, "bow"));

	public static void registerItemGroups()
	{
		PixlBows.LOGGER.debug("Registering Mod Item Groups for " + PixlBows.MOD_ID);

		Registry.register(Registries.ITEM_GROUP, TANZANITE, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ModItems.TANZANITE))
				.displayName(Text.translatable("itemgroup.pixlbows.tanzanite"))
				.build());

		Registry.register(Registries.ITEM_GROUP, BOW, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ModItems.EXPLOSIVE_BOW))
				.displayName(Text.translatable("itemgroup.pixlbows.bow"))
				.build());
	}
}

package dev.pixl.pixlbows.villager;

import com.google.common.collect.ImmutableSet;
import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers
{
	public static final PointOfInterestType JUMPY_POI = registerPOI("jumpy_poi", ModBlocks.JUMPY_BLOCK);
	public static final VillagerProfession JUMP_MASTER = registerProfession("jump_master",
			RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(PixlBows.MOD_ID, "jumpy_poi")));

	public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type)
	{
		return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(PixlBows.MOD_ID, name),
				new VillagerProfession(
						new Identifier(PixlBows.MOD_ID, name).toString(),
						(pointOfInterestType) -> pointOfInterestType.getKey().isPresent() && pointOfInterestType.getKey().get() == type,
						null,
						ImmutableSet.of(),
						ImmutableSet.of(),
						SoundEvents.ENTITY_VILLAGER_WORK_ARMORER
				));
	}

	public static PointOfInterestType registerPOI(String name, Block block)
	{
		return PointOfInterestHelper.register(new Identifier(PixlBows.MOD_ID, name),
				1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
	}

	public static void registerVillagers()
	{
		PixlBows.LOGGER.debug("Registering Villagers for " + PixlBows.MOD_ID);
	}

	public static void registerTrades()
	{
		TradeOfferHelper.registerVillagerOffers(JUMP_MASTER, 1,
				factories -> {
					factories.add((entity, random) -> new TradeOffer(
							new ItemStack(Items.EMERALD, 3),
							new ItemStack(ModItems.EGGPLANT, 5),
							6, 2, 0.02f
					));
				});
	}
}

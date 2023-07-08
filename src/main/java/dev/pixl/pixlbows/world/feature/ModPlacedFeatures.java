package dev.pixl.pixlbows.world.feature;

import dev.pixl.pixlbows.PixlBows;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures
{
	public static final RegistryKey<PlacedFeature> TANZANITE_ORE_PLACED_KEY = registerKey("tanzanite_ore_placed");
	public static final RegistryKey<PlacedFeature> NETHER_TANZANITE_ORE_PLACED_KEY = registerKey("nether_tanzanite_ore_placed");
	public static final RegistryKey<PlacedFeature> END_TANZANITE_ORE_PLACED_KEY = registerKey("end_tanzanite_ore_placed");

	public static void bootstrap(Registerable<PlacedFeature> context)
	{
		var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		register(context, TANZANITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TANZANITE_ORE_KEY),
				modifiersWithCount(16,
						HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
		register(context, NETHER_TANZANITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_TANZANITE_ORE_KEY),
				modifiersWithCount(16,
						HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
		register(context, END_TANZANITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_TANZANITE_ORE_KEY),
				modifiersWithCount(16,
						HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
	}

	public static RegistryKey<PlacedFeature> registerKey(String name)
	{
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PixlBows.MOD_ID, name));
	}

	private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
	                             RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers)
	{
		context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
	                                                                               RegistryEntry<ConfiguredFeature<?, ?>> configuration,
	                                                                               PlacementModifier... modifiers)
	{
		register(context, key, configuration, List.of(modifiers));
	}

	private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier)
	{
		return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
	}

	private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier)
	{
		return modifiers(CountPlacementModifier.of(count), heightModifier);
	}

	private static List<PlacementModifier> modifiersWithChance(int chance, PlacementModifier heightModifier)
	{
		return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
	}
}

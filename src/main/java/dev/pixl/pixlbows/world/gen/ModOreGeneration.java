package dev.pixl.pixlbows.world.gen;

import dev.pixl.pixlbows.world.feature.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration
{
	public static void generateOres()
	{
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.TANZANITE_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_TANZANITE_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.END_TANZANITE_ORE_PLACED_KEY);
	}
}

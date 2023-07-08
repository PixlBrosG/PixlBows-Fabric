package dev.pixl.pixlbows.world.feature;

import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures
{
	public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_ORE_KEY = registerKey("tanzanite_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TANZANITE_ORE_KEY = registerKey("nether_tanzanite_ore");
	public static final RegistryKey<ConfiguredFeature<?, ?>> END_TANZANITE_ORE_KEY = registerKey("endstone_tanzanite_ore");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
	{
		RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
		RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
		RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

		List<OreFeatureConfig.Target> overworldTanzaniteOres =
				List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TANZANITE_ORE.getDefaultState()),
						OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState()));
		List<OreFeatureConfig.Target> netherTanzaniteOres =
				List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_TANZANITE_ORE.getDefaultState()));
		List<OreFeatureConfig.Target> endTanzaniteOres =
				List.of(OreFeatureConfig.createTarget(endstoneReplaceables, ModBlocks.END_TANZANITE_ORE.getDefaultState()));

		register(context, TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTanzaniteOres, 12));
		register(context, NETHER_TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTanzaniteOres, 12));
		register(context, END_TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endTanzaniteOres, 12));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
	{
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(PixlBows.MOD_ID, name));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
	                                                                               RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
	{
		context.register(key, new ConfiguredFeature<>(feature, configuration));
	}
}

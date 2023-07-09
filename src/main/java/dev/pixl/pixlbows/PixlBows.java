package dev.pixl.pixlbows;

import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.event.PlayerTickHandler;
import dev.pixl.pixlbows.fluid.ModFluids;
import dev.pixl.pixlbows.item.ModItemGroups;
import dev.pixl.pixlbows.item.ModItems;
import dev.pixl.pixlbows.networking.ModMessagesServer;
import dev.pixl.pixlbows.painting.ModPaintings;
import dev.pixl.pixlbows.util.ModLootTableModifiers;
import dev.pixl.pixlbows.villager.ModVillagers;
import dev.pixl.pixlbows.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PixlBows implements ModInitializer
{
    public static final String MOD_ID = "pixlbows";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize()
    {
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModFluids.register();

        ModVillagers.registerVillagers();
        ModVillagers.registerTrades();

        ModPaintings.registerPaintings();

        ModWorldGen.generateWorldGen();

        ModLootTableModifiers.modifyLootTables();

        ModMessagesServer.registerPackets();

        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
}
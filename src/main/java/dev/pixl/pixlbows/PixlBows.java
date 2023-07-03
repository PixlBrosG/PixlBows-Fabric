package dev.pixl.pixlbows;

import dev.pixl.pixlbows.block.ModBlocks;
import dev.pixl.pixlbows.item.ModItemGroups;
import dev.pixl.pixlbows.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
    }
}
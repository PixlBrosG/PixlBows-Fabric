package dev.pixl.pixlbows.networking;

import dev.pixl.pixlbows.PixlBows;
import dev.pixl.pixlbows.networking.packet.DrinkingPacket;
import dev.pixl.pixlbows.networking.packet.ExamplePacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessagesServer
{
	public static final Identifier DRINKING_ID = new Identifier(PixlBows.MOD_ID, "drinking");
	public static final Identifier THIRST_SYNC_ID = new Identifier(PixlBows.MOD_ID, "thirst_sync");
	public static final Identifier EXAMPLE_ID = new Identifier(PixlBows.MOD_ID, "example");

	public static void registerPackets()
	{
		ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExamplePacket::receive);
		ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingPacket::receive);
	}
}

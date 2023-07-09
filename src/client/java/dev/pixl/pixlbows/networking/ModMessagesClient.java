package dev.pixl.pixlbows.networking;

import dev.pixl.pixlbows.networking.packet.ThirstSyncDataPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ModMessagesClient
{
	public static void registerPackets()
	{
		ClientPlayNetworking.registerGlobalReceiver(ModMessagesServer.THIRST_SYNC_ID, ThirstSyncDataPacket::receive);
	}
}

package dev.pixl.pixlbows.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;

public class ThirstData
{
	public static int addThirst(IEntityDataSaver player, int amount)
	{
		NbtCompound nbt = player.getPersistentData();
		int thirst = nbt.getInt("thirst");

		thirst += amount;
		if (thirst > 10)
			thirst = 10;

		nbt.putInt("thirst", thirst);
		return thirst;
	}

	public static int removeThirst(IEntityDataSaver player, int amount)
	{
		NbtCompound nbt = player.getPersistentData();
		int thirst = nbt.getInt("thirst");

		thirst -= amount;
		if (thirst < 0)
			thirst = 0;

		nbt.putInt("thirst", thirst);
		return thirst;
	}
}

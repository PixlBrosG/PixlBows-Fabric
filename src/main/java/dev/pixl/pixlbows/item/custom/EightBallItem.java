package dev.pixl.pixlbows.item.custom;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item
{
	public EightBallItem(Settings settings)
	{
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
	{
		// !world.isClient makes sure this happens server-side
		if (!world.isClient() && hand == Hand.MAIN_HAND)
		{
			outputRandomNumber(user);
			user.getItemCooldownManager().set(this, 20);
		}

		return super.use(world, user, hand);
	}

	private void outputRandomNumber(PlayerEntity player)
	{
		player.sendMessage(Text.literal("Your number is " + getRandomNumber()));
	}

	private int getRandomNumber()
	{
		return Random.createLocal().nextInt(10);
	}
}

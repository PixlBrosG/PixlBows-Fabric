package dev.pixl.pixlbows.block.custom;

import net.minecraft.block.Block;

public class JumpyBlock extends Block
{
	public JumpyBlock(Settings settings) { super(settings); }

	@Override
	public float getJumpVelocityMultiplier() {
		return 2.0f * super.getJumpVelocityMultiplier();
	}
}

package dev.pixl.pixlbows.mixin.client;

import dev.pixl.pixlbows.ui.HudOverlay;
import dev.pixl.pixlbows.ui.ThirstHudOverlay;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin
{
	@Shadow public abstract void tick(boolean paused);

	@Inject(method = "render", at = @At("HEAD"))
	public void render(DrawContext context, float tickDelta, CallbackInfo ci)
	{
		ThirstHudOverlay.render(context, tickDelta);
		HudOverlay.render(context, tickDelta);
	}
}

package dev.pixl.pixlbows.mixin;

import dev.pixl.pixlbows.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin<R> implements IEntityDataSaver
{
	@Unique
	private NbtCompound persistentData;

	@Override
	public NbtCompound getPersistentData()
	{
		if (persistentData == null)
			persistentData = new NbtCompound();

		return persistentData;
	}

	@Inject(method = "writeNbt", at = @At("HEAD"))
	protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<R> info)
	{
		if (persistentData != null)
			nbt.put("pixlbows.pixlbows_data", persistentData);
	}

	@Inject(method = "readNbt", at = @At("HEAD"))
	protected void injectReadMethod(NbtCompound nbt, CallbackInfo info)
	{
		if (nbt.contains("pixlbows.pixlbows_data", 10))
			persistentData = nbt.getCompound("pixlbows.pixlbows_data");
	}
}

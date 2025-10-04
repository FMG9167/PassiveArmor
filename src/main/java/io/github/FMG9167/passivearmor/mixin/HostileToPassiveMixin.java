package io.github.FMG9167.passivearmor.mixin;

import io.github.FMG9167.passivearmor.PassiveArmorStuff;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public class HostileToPassiveMixin {
    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    private void onSetTarget(LivingEntity target, CallbackInfo ci){
        if(PassiveArmorStuff.shouldBePassive((MobEntity)(Object)this, target)) {
            ci.cancel();
        }
    }
}

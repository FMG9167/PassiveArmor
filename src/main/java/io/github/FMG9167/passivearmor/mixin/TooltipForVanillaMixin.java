package io.github.FMG9167.passivearmor.mixin;


import io.github.FMG9167.passivearmor.PassiveArmorComponents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Mixin(Item.class)
public abstract class TooltipForVanillaMixin {

    @Inject(method = "appendTooltip", at = @At("HEAD"), cancellable = true)
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type, CallbackInfo ci) {
        if (stack.getItem() instanceof ArmorItem && !Objects.equals(stack.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY, ""), "")) {
            tooltip.add(Text.literal("Hidden from "+stack.get(PassiveArmorComponents.PASSIVE_ENTITY)+"s").formatted(Formatting.GOLD));
            ci.cancel();
        }

    }
}

package io.github.FMG9167.passivearmor.mixin;


import io.github.FMG9167.passivearmor.PassiveArmorComponents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
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
import java.util.function.Consumer;

@Mixin(Item.class)
public abstract class TooltipForVanillaMixin {

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    public void getTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type, CallbackInfo ci) {
        EquippableComponent piece = stack.get(DataComponentTypes.EQUIPPABLE);
        boolean isArmor = piece != null &&
                (piece.slot().getName().equals("head") ||
                        piece.slot().getName().equals("chest") ||
                        piece.slot().getName().equals("legs") ||
                        piece.slot().getName().equals("feet"));
        if (isArmor && !Objects.equals(stack.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY, ""), "")) {
            textConsumer.accept(Text.literal("Hidden from "+stack.get(PassiveArmorComponents.PASSIVE_ENTITY)+"s").formatted(Formatting.GOLD));
        }

        String name = stack.getName().getString().toLowerCase();
        if(List.of("zombie catalyst", "skeleton catalyst", "creeper catalyst", "spider catalyst",
                        "raider catalyst", "witherskeleton catalyst", "enderman catalyst", "shulker catalyst",
                        "slime catalyst", "magmacube catalyst", "ghast catalyst", "blaze catalyst",
                        "phantom catalyst")
                .contains(name)) {
            textConsumer.accept(Text.translatable("item.passivearmor."+String.join("_", name.split(" "))+".tooltip",  stack.getItemName().getString().split(" ")[0]).formatted(Formatting.GOLD));
        }
    }
}

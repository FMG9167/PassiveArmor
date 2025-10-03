package io.github.FMG9167.passivearmor.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {

    @Shadow @Final private Property levelCost;

    public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, ForgingSlotsManager forgingSlotsManager) {
        super(type, syncId, playerInventory, context, forgingSlotsManager);
    }


    @Inject(method = "updateResult", at = @At("TAIL"))
    private void updateResult(CallbackInfo ci){
        ItemStack leftInput = this.input.getStack(0);
        ItemStack rightInput = this.input.getStack(1);

        if(!leftInput.isEmpty() && !rightInput.isEmpty()){
            EquippableComponent equippable = leftInput.get(DataComponentTypes.EQUIPPABLE);
            boolean isArmor = equippable != null &&
                    (       equippable.slot().getName().equals("head") ||
                            equippable.slot().getName().equals("chest") ||
                            equippable.slot().getName().equals("legs") ||
                            equippable.slot().getName().equals("feet"));
            if(isArmor && rightInput.isIn(ItemTags.ANVIL)){}
        }

    }
}

package io.github.FMG9167.passivearmor.mixin;

import io.github.FMG9167.passivearmor.PassiveArmorComponents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.*;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

import static io.github.FMG9167.passivearmor.PassiveArmorItems.catalysts;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin{

    @Shadow @Final private Property levelCost;

    @Shadow
    @Final
    private static Logger LOGGER;

    @Shadow
    private boolean keepSecondSlot;

    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    private void updateResult(CallbackInfo ci){
        ForgingScreenHandlerAccessor accessor = (ForgingScreenHandlerAccessor)this;
        Inventory input = accessor.getInput();
        CraftingResultInventory output = accessor.getOutput();

        ItemStack leftInput = input.getStack(0);
        ItemStack rightInput = input.getStack(1);

        if(!leftInput.isEmpty() && !rightInput.isEmpty()){
            EquippableComponent piece = leftInput.get(DataComponentTypes.EQUIPPABLE);
            boolean isArmor = piece != null &&
                            (piece.slot().getName().equals("head") ||
                            piece.slot().getName().equals("chest") ||
                            piece.slot().getName().equals("legs") ||
                            piece.slot().getName().equals("feet"));
            if(isArmor) {
                if (catalysts.contains(rightInput.getItem())) {
                    ItemStack result = leftInput.copy();
                    String name = rightInput.getItemName().toString().split("'")[1].split("\\.")[2].split("_")[0].toUpperCase();
                    result.set(PassiveArmorComponents.PASSIVE_ENTITY, name);
                    LOGGER.info(Arrays.toString(rightInput.getItemName().toString().split(" ")));
                    output.setStack(0, result);
                    this.levelCost.set(5);
                    this.keepSecondSlot = true;
                    ci.cancel();
                }
            }
        }

    }
}

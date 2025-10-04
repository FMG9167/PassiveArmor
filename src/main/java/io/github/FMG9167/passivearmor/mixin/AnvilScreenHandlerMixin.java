package io.github.FMG9167.passivearmor.mixin;

import io.github.FMG9167.passivearmor.PassiveArmorComponents;
import net.minecraft.block.entity.ChiseledBookshelfBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.ForgingSlotsManager;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin{

    @Shadow @Final private Property levelCost;

    @Shadow
    @Final
    private static Logger LOGGER;


    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    private void updateResult(CallbackInfo ci){
        ForgingScreenHandlerAccessor accessor = (ForgingScreenHandlerAccessor)this;
        Inventory input = accessor.getInput();
        CraftingResultInventory output = accessor.getOutput();

        ItemStack leftInput = input.getStack(0);
        ItemStack rightInput = input.getStack(1);

        if(!leftInput.isEmpty() && !rightInput.isEmpty()){
            EquippableComponent equippable = leftInput.get(DataComponentTypes.EQUIPPABLE);
            boolean isArmor = equippable != null &&
                            (equippable.slot().getName().equals("head") ||
                            equippable.slot().getName().equals("chest") ||
                            equippable.slot().getName().equals("legs") ||
                            equippable.slot().getName().equals("feet"));
            LOGGER.info(equippable.toString());
            if(isArmor) {
                if (rightInput.getItem() == Items.ROTTEN_FLESH) {
                    ItemStack result = leftInput.copy();
                    result.set(PassiveArmorComponents.PASSIVE_ENTITY, "Zombie");
                    output.setStack(0, result);
                    this.levelCost.set(5);
                    ci.cancel();
                }
            }
        }

    }
}

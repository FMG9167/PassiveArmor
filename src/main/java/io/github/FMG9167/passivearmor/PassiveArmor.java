package io.github.FMG9167.passivearmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class PassiveArmor implements ModInitializer {
    public static final String MOD_ID = "passivearmor";

    public static String toTitle(String input) {
        String[] lower =  input.toLowerCase().split("");
        lower[0] = lower[0].toUpperCase();
        return String.join("", lower);
    }

    @Override
    public void onInitialize() {
        PassiveArmorItems.initialize();
        PassiveArmorComponents.initialize();
        PassiveArmorStuff.initialize();


        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooptipType, list) -> {
            String name = itemStack.getName().getString().toLowerCase();
            if(List.of("zombie catalyst", "skeleton catalyst", "creeper catalyst", "spider catalyst",
                                "raider catalyst", "witherskeleton catalyst", "enderman catalyst", "shulker catalyst",
                                "slime catalyst", "magmacube catalyst", "ghast catalyst", "blaze catalyst",
                                "phantom catalyst")
                    .contains(name)) {
                list.add(Text.translatable("item.passivearmor."+String.join("_", name.split(" "))+".tooltip",  itemStack.getItemName().getString().split(" ")[0]).formatted(Formatting.GOLD));
            }
        });

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            EquippableComponent piece = itemStack.get(DataComponentTypes.EQUIPPABLE);
            boolean isArmor = piece != null &&
                    (       piece.slot().getName().equals("head")  ||
                            piece.slot().getName().equals("chest") ||
                            piece.slot().getName().equals("legs")  ||
                            piece.slot().getName().equals("feet")  );
            if (!isArmor) {
                return;
            }
            if(itemStack.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY, "").isEmpty()){
                return;
            }
            list.add(Text.translatable("item.passivearmor."+String.join("_",itemStack.getItemName().getString().toLowerCase().split(" "))+".tooltip", itemStack.get(PassiveArmorComponents.PASSIVE_ENTITY)).formatted(Formatting.GOLD));
        });
    }
}
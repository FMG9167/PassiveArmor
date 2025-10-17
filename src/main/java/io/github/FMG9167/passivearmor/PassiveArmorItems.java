package io.github.FMG9167.passivearmor;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class PassiveArmorItems {
    public static final RegistryKey<ItemGroup> PASSIVE_ARMOR_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PassiveArmor.MOD_ID, "item_group"));
    public static final ItemGroup PASSIVE_ARMOR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.IRON_CHESTPLATE))
            .displayName(Text.translatable("itemGroup.passivearmor"))
            .build();


    public static Item register(Item item, String id){
        Identifier itemID = Identifier.of(PassiveArmor.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static Item register(String id){
        return register(new Item(new Item.Settings()) {
            @Override
            public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                tooltip.add(Text.translatable("item.passivearmor."+id+".tooltip").formatted(Formatting.GOLD));
            }
        }, id);
    }

    public static final Item ZOMBIE_CATALYST = register("zombie_catalyst");
    public static final Item SKELETON_CATALYST = register("skeleton_catalyst");
    public static final Item CREEPER_CATALYST = register("creeper_catalyst");
    public static final Item SPIDER_CATALYST = register("spider_catalyst");
    public static final Item RAIDER_CATALYST = register("raider_catalyst");
    public static final Item WITHER_SKELETON_CATALYST = register("witherskeleton_catalyst");
    public static final Item ENDERMAN_CATALYST = register("enderman_catalyst");
    public static final Item SHULKER_CATALYST = register("shulker_catalyst");
    public static final Item SLIME_CATALYST = register("slime_catalyst");
    public static final Item MAGMACUBE_CATALYST = register("magmacube_catalyst");
    public static final Item GHAST_CATALYST = register("ghast_catalyst");
    public static final Item BLAZE_CATALYST = register("blaze_catalyst");
    public static final Item PHANTOM_CATALYST = register("phantom_catalyst");


    public static final List<Item> catalysts = List.of(
            ZOMBIE_CATALYST,
            SKELETON_CATALYST,
            CREEPER_CATALYST,
            SPIDER_CATALYST,
            RAIDER_CATALYST,
            WITHER_SKELETON_CATALYST,
            ENDERMAN_CATALYST,
            SHULKER_CATALYST,
            SLIME_CATALYST,
            MAGMACUBE_CATALYST,
            GHAST_CATALYST,
            BLAZE_CATALYST,
            PHANTOM_CATALYST);

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, PASSIVE_ARMOR_GROUP_KEY, PASSIVE_ARMOR_GROUP);

        ItemGroupEvents.modifyEntriesEvent(PASSIVE_ARMOR_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ZOMBIE_CATALYST);
            itemGroup.add(SKELETON_CATALYST);
            itemGroup.add(CREEPER_CATALYST);
            itemGroup.add(SPIDER_CATALYST);
            itemGroup.add(RAIDER_CATALYST);
            itemGroup.add(WITHER_SKELETON_CATALYST);
            itemGroup.add(ENDERMAN_CATALYST);
            itemGroup.add(SHULKER_CATALYST);
            itemGroup.add(SLIME_CATALYST);
            itemGroup.add(MAGMACUBE_CATALYST);
            itemGroup.add(GHAST_CATALYST);
            itemGroup.add(BLAZE_CATALYST);
            itemGroup.add(PHANTOM_CATALYST);
        });
    }
}

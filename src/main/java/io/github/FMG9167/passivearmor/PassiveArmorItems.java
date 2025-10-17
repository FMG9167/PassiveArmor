package io.github.FMG9167.passivearmor;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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

    public static final Item ZOMBIE_CATALYST = register(new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type){
            tooltip.add(Text.translatable("item.passivearmor.zombie_catalyst"));
        }
    }, "zombie_catalyst");
    public static final Item SKELETON_CATALYST = null;
    public static final Item CREEPER_CATALYST = null;
    public static final Item SPIDER_CATALYST = null;
    public static final Item RAIDER_CATALYST = null;
    public static final Item WITHER_SKELETON_CATALYST = null;
    public static final Item ENDERMAN_CATALYST = null;
    public static final Item SHULKER_CATALYST = null;
    public static final Item SLIME_CATALYST = null;
    public static final Item MAGMACUBE_CATALYST = null;
    public static final Item GHAST_CATALYST = null;
    public static final Item BLAZE_CATALYST = null;
    public static final Item PHANTOM_CATALYST = null;

    public static final Map<Item, String> itemMap = new HashMap<>();

    static {
        itemMap.put(ZOMBIE_CATALYST, "zombie_catalyst");
        itemMap.put(SKELETON_CATALYST, "skeleton_catalyst");
        itemMap.put(CREEPER_CATALYST, "creeper_catalyst");
        itemMap.put(SPIDER_CATALYST, "spider_catalyst");
        itemMap.put(RAIDER_CATALYST, "raider_catalyst");
        itemMap.put(WITHER_SKELETON_CATALYST, "witherskeleton_catalyst");
        itemMap.put(ENDERMAN_CATALYST, "enderman_catalyst");
        itemMap.put(SHULKER_CATALYST, "shulker_catalyst");
        itemMap.put(SLIME_CATALYST, "slime_catalyst");
        itemMap.put(MAGMACUBE_CATALYST, "magmacube_catalyst");
        itemMap.put(GHAST_CATALYST, "ghast_catalyst");
        itemMap.put(BLAZE_CATALYST, "blaze_catalyst");
        itemMap.put(PHANTOM_CATALYST, "phantom_catalyst");
    }

//        item = register(new Item(new Item.Settings()) {
//            @Override
//            public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
//                tooltip.add(Text.translatable("item.passivearmor.zombie_catalyst"));
//            }
//        }, "zombie_catalyst");

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

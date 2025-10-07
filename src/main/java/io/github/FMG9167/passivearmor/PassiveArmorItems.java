package io.github.FMG9167.passivearmor;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Function;

public class PassiveArmorItems {
    public static final RegistryKey<ItemGroup> PASSIVE_ARMOR_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PassiveArmor.MOD_ID, "item_group"));
    public static final ItemGroup PASSIVE_ARMOR_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.IRON_CHESTPLATE))
            .displayName(Text.translatable("itemGroup.passivearmor"))
            .build();


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings){
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PassiveArmor.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static final Item ZOMBIE_CATALYST = register("zombie_catalyst", Item::new, new Item.Settings());
    public static final Item SKELETON_CATALYST = register("skeleton_catalyst", Item::new, new Item.Settings());
    public static final Item CREEPER_CATALYST = register("creeper_catalyst", Item::new, new Item.Settings());
    public static final Item SPIDER_CATALYST = register("spider_catalyst", Item::new, new Item.Settings());
    public static final Item WITCH_CATALYST = register("witch_catalyst", Item::new, new Item.Settings());
    public static final Item PIGLIN_CATALYST = register("piglin_catalyst", Item::new, new Item.Settings());
    public static final Item BRUTE_CATALYST = register("brute_catalyst", Item::new, new Item.Settings());
    public static final Item WITHER_SKELETON_CATALYST =  register("witherskeleton_catalyst", Item::new, new Item.Settings());


    public static final List<Item> catalysts = List.of(
            ZOMBIE_CATALYST,
            SKELETON_CATALYST,
            CREEPER_CATALYST,
            SPIDER_CATALYST,
            WITCH_CATALYST,
            PIGLIN_CATALYST,
            BRUTE_CATALYST,
            WITHER_SKELETON_CATALYST);

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, PASSIVE_ARMOR_GROUP_KEY, PASSIVE_ARMOR_GROUP);

        ItemGroupEvents.modifyEntriesEvent(PASSIVE_ARMOR_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ZOMBIE_CATALYST);
            itemGroup.add(SKELETON_CATALYST);
            itemGroup.add(CREEPER_CATALYST);
            itemGroup.add(SPIDER_CATALYST);
            itemGroup.add(WITCH_CATALYST);
            itemGroup.add(PIGLIN_CATALYST);
            itemGroup.add(BRUTE_CATALYST);
            itemGroup.add(WITHER_SKELETON_CATALYST);
        });
    }
}

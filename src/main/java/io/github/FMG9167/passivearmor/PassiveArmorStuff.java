package io.github.FMG9167.passivearmor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassiveArmorStuff {
    private static final Map<String, Class<? extends HostileEntity>> EntityIndex = new HashMap<>();

    static {
        EntityIndex.put("Zombie", ZombieEntity.class);
        EntityIndex.put("Skeleton", SkeletonEntity.class);
        EntityIndex.put("Creeper", CreeperEntity.class);
        EntityIndex.put("Spider", SpiderEntity.class);
        EntityIndex.put("Enderman", EndermanEntity.class);
        EntityIndex.put("Witch", WitchEntity.class);
        EntityIndex.put("Piglin", PiglinEntity.class);
        EntityIndex.put("PiglinBrute", PiglinBruteEntity.class);
        EntityIndex.put("WitherSkeleton", WitherSkeletonEntity.class);
    }

    private static String getEquippedArmorComponent(PlayerEntity player) {
        String helmet = player.getEquippedStack(EquipmentSlot.HEAD).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String chestplate = player.getEquippedStack(EquipmentSlot.CHEST).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String leggings = player.getEquippedStack(EquipmentSlot.LEGS).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String boots = player.getEquippedStack(EquipmentSlot.FEET).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String full = helmet + " " + chestplate + " " + leggings + " " + boots;
        List<String> list = Arrays.asList(full.split(" "));
        list.removeAll(List.of(""));
        return String.join(" ", list);
    }

    public static boolean shouldBePassive(MobEntity mob, LivingEntity target){
        boolean[] hiddenMobClasses = new boolean[EntityIndex.size()];
        if(!(target instanceof PlayerEntity player)){
            return false;
        }

        String component = getEquippedArmorComponent(player);
        if(component == ""){
            return false;
        }

        for(String curMob : component.split(" ")){
            if(EntityIndex.containsKey(curMob) && EntityIndex.get(curMob).isInstance(mob)){
                return true;
            }
        }
        return false;
    }

    public static void initialize(){
    }
}

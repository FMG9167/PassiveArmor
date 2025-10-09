package io.github.FMG9167.passivearmor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassiveArmorStuff {
    private static final Map<String, List<Class<? extends MobEntity>>> EntityIndex = new HashMap<>();

    static {
        EntityIndex.put("Zombie", List.of(ZombieEntity.class));
        EntityIndex.put("Skeleton", List.of(SkeletonEntity.class, BoggedEntity.class, StrayEntity.class));
        EntityIndex.put("Creeper", List.of(CreeperEntity.class));
        EntityIndex.put("Spider", List.of(SpiderEntity.class));
        EntityIndex.put("Witherskeleton", List.of(WitherSkeletonEntity.class));
        EntityIndex.put("Enderman", List.of(EndermanEntity.class));
        EntityIndex.put("Raider", List.of(RaiderEntity.class, VexEntity.class));
        EntityIndex.put("Shulker", List.of(ShulkerEntity.class));
        EntityIndex.put("Slime", List.of(SlimeEntity.class));
        EntityIndex.put("MagmaCube", List.of(MagmaCubeEntity.class));
        EntityIndex.put("Ghast", List.of(GhastEntity.class));
        EntityIndex.put("Blaze", List.of(BlazeEntity.class));
        EntityIndex.put("Phantom", List.of(PhantomEntity.class));

    }

    private static String getEquippedArmorComponent(PlayerEntity player) {
        String helmet = player.getEquippedStack(EquipmentSlot.HEAD).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String chestplate = player.getEquippedStack(EquipmentSlot.CHEST).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String leggings = player.getEquippedStack(EquipmentSlot.LEGS).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String boots = player.getEquippedStack(EquipmentSlot.FEET).getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        String full = helmet + " " + chestplate + " " + leggings + " " + boots;
        List<String> list = Arrays.asList(full.strip().split(" "));
        return String.join(" ", list);
    }

    public static boolean shouldBePassive(MobEntity mob, LivingEntity target){
        if(mob == null || target == null) return false;
        if(mob.isRemoved() || target.isRemoved()) return false;
        if(!(target instanceof PlayerEntity player)){
            return false;
        }

        String component = getEquippedArmorComponent(player);
        if(component.isEmpty()){
            return false;
        }

        for(String curMob : component.split(" ")){
            if(EntityIndex.containsKey(curMob)){
                for(Class<? extends MobEntity> curClass : EntityIndex.get(curMob)){
                    if(curClass.isInstance(mob)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void initialize(){
    }
}
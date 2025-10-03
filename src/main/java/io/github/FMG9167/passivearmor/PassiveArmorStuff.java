package io.github.FMG9167.passivearmor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PassiveArmorStuff {
    private static final Map<String, Class<? extends HostileEntity>> ARMOR_MOB_MAP = new HashMap<>();


    private static String[] getEquippedArmorComponent(PlayerEntity player) {
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

        String val = helmet.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"");
        if(chestplate.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY, "") != "") {
            val = val + "," + chestplate.get(PassiveArmorComponents.PASSIVE_ENTITY);
        };
        if(leggings.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY, "") != "") {
            val = val + "," + leggings.get(PassiveArmorComponents.PASSIVE_ENTITY);
        };
        if(boots.getOrDefault(PassiveArmorComponents.PASSIVE_ENTITY,"") != "") {
            val = val + "," + boots.get(PassiveArmorComponents.PASSIVE_ENTITY);
        };
        if(val == null){
            return null;
        }
        return val.split(",");
    }

    public static void initialize(){
    }
}

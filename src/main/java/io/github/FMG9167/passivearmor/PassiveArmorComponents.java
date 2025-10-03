package io.github.FMG9167.passivearmor;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PassiveArmorComponents {

    public static final ComponentType<String> PASSIVE_ENTITY = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(PassiveArmor.MOD_ID, "passive_entity_component"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    protected static void initialize() {}
}

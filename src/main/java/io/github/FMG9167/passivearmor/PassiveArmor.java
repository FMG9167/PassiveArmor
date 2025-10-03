package io.github.FMG9167.passivearmor;

import net.fabricmc.api.ModInitializer;

public class PassiveArmor implements ModInitializer {
    public static final String MOD_ID = "passivearmor";


    @Override
    public void onInitialize() {
        PassiveArmorComponents.initialize();
        PassiveArmorStuff.initialize();
    }
}
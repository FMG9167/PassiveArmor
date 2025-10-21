package io.github.FMG9167.passivearmor;

import net.fabricmc.api.ModInitializer;

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
    }
}
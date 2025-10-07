package io.github.FMG9167.passivearmor.client;

import io.github.FMG9167.passivearmor.client.datagen.PassiveArmorModelProvider;
import io.github.FMG9167.passivearmor.client.datagen.PassiveArmorRecipeProvider;
import io.github.FMG9167.passivearmor.client.datagen.PassiveArmorTranslationProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PassiveArmorDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(PassiveArmorTranslationProvider::new);
        pack.addProvider(PassiveArmorModelProvider::new);
        pack.addProvider(PassiveArmorRecipeProvider::new);
    }
}

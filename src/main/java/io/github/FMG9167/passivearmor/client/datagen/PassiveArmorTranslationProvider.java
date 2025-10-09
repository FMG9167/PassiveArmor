package io.github.FMG9167.passivearmor.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PassiveArmorTranslationProvider extends FabricLanguageProvider {
    public PassiveArmorTranslationProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

        for(String i : List.of("Zombie Catalyst", "Skeleton Catalyst", "Creeper Catalyst", "Spider Catalyst", "Raider Catalyst",
                "Enderman Catalyst", "WitherSkeleton Catalyst", "Shulker Catalyst", "Slime Catalyst", "MagmaCube Catalyst",
                "Ghast Catalyst", "Blaze Catalyst", "Phantom Catalyst")){
            String join = String.join("_", i.toLowerCase().split(" "));
            translationBuilder.add("item.passivearmor."+join, i);
            translationBuilder.add("item.passivearmor."+ join +".tooltip", "Will hide you from %1$ss when applied to armor");
        }

        for(String i : List.of("leather", "chainmail", "iron", "golden", "diamond", "netherite")){
            for(String j : List.of("helmet", "chestplate", "leggings", "boots")) {
                translationBuilder.add("item.passivearmor."+i+"_"+j+".tooltip", "Hidden from %1$ss");
            }
        }

        translationBuilder.add("itemGroup.passivearmor", "Passive Armor");

    }
}

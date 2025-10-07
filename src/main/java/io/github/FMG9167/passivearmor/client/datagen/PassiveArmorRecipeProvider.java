package io.github.FMG9167.passivearmor.client.datagen;

import io.github.FMG9167.passivearmor.PassiveArmorItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PassiveArmorRecipeProvider extends FabricRecipeProvider {
    public PassiveArmorRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.COMBAT, PassiveArmorItems.ZOMBIE_CATALYST, 1)
                        .pattern("111")
                        .pattern("121")
                        .pattern("111")
                        .input('1', Items.ROTTEN_FLESH)
                        .input('2', Items.NETHER_STAR)
                        .group("combat")
                        .criterion(hasItem(PassiveArmorItems.ZOMBIE_CATALYST), conditionsFromItem(PassiveArmorItems.ZOMBIE_CATALYST))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}

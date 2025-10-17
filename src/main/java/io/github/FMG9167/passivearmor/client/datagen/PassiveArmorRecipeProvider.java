package io.github.FMG9167.passivearmor.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static io.github.FMG9167.passivearmor.PassiveArmorItems.*;

public class PassiveArmorRecipeProvider extends FabricRecipeProvider {
    public PassiveArmorRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        Map<Item, Item> itemToIngredient = new HashMap<>();

        itemToIngredient.put(ZOMBIE_CATALYST, Items.ROTTEN_FLESH);
        itemToIngredient.put(SKELETON_CATALYST, Items.BONE);
        itemToIngredient.put(CREEPER_CATALYST, Items.GUNPOWDER);
        itemToIngredient.put(SPIDER_CATALYST, Items.SPIDER_EYE);
        itemToIngredient.put(RAIDER_CATALYST, Items.CROSSBOW);
        itemToIngredient.put(WITHER_SKELETON_CATALYST, Items.WITHER_SKELETON_SKULL);
        itemToIngredient.put(ENDERMAN_CATALYST, Items.ENDER_PEARL);
        itemToIngredient.put(SHULKER_CATALYST, Items.SHULKER_SHELL);
        itemToIngredient.put(SLIME_CATALYST, Items.SLIME_BALL);
        itemToIngredient.put(MAGMACUBE_CATALYST, Items.MAGMA_CREAM);
        itemToIngredient.put(GHAST_CATALYST, Items.GHAST_TEAR);
        itemToIngredient.put(BLAZE_CATALYST, Items.BLAZE_ROD);
        itemToIngredient.put(PHANTOM_CATALYST, Items.PHANTOM_MEMBRANE);

        for (Item item : catalysts) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, item, 1)
                    .pattern("111")
                    .pattern("121")
                    .pattern("111")
                    .input('1', itemToIngredient.get(item))
                    .input('2', Items.NETHER_STAR)
                    .group("combat")
                    .criterion(hasItem(item), conditionsFromItem(item))
                    .offerTo(recipeExporter);
        }
    }
}

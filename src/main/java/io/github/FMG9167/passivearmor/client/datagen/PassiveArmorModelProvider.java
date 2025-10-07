package io.github.FMG9167.passivearmor.client.datagen;

import io.github.FMG9167.passivearmor.PassiveArmorItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;

public class PassiveArmorModelProvider extends FabricModelProvider {
    public PassiveArmorModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for(Item i : PassiveArmorItems.catalysts){
            itemModelGenerator.register(i, Models.GENERATED);
        }
    }
}

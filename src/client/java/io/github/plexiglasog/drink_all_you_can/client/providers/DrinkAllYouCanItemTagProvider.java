package io.github.plexiglasog.drink_all_you_can.client.providers;

import io.github.plexiglasog.drink_all_you_can.effect.custom.SmokerColaEffect;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DrinkAllYouCanItemTagProvider extends FabricTagProvider<Item> {
    public DrinkAllYouCanItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(SmokerColaEffect.DRINK_ALL_YOU_CAN_RAW_MEAT)
                .add(Registries.ITEM.getId(Items.BEEF))
                .add(Registries.ITEM.getId(Items.PORKCHOP))
                .add(Registries.ITEM.getId(Items.CHICKEN))
                .add(Registries.ITEM.getId(Items.MUTTON))
                .add(Registries.ITEM.getId(Items.RABBIT))
                .add(Registries.ITEM.getId(Items.SALMON))
                .add(Registries.ITEM.getId(Items.COD))
        ;
    }
}

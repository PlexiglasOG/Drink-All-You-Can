package io.github.plexiglasog.drink_all_you_can.client;

import io.github.plexiglasog.drink_all_you_can.client.providers.Drink_all_you_canItemTagProvider;
import io.github.plexiglasog.drink_all_you_can.client.providers.Drink_all_you_canModelProvider;
import io.github.plexiglasog.drink_all_you_can.client.providers.Drink_all_you_canRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class Drink_all_you_canDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(Drink_all_you_canModelProvider::new);
        pack.addProvider(Drink_all_you_canRecipeProvider::new);
        pack.addProvider(Drink_all_you_canItemTagProvider::new);
    }
}

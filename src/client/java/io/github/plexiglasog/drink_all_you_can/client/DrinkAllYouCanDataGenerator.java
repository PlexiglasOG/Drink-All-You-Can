package io.github.plexiglasog.drink_all_you_can.client;

import io.github.plexiglasog.drink_all_you_can.client.providers.DrinkAllYouCanItemTagProvider;
import io.github.plexiglasog.drink_all_you_can.client.providers.DrinkAllYouCanModelProvider;
import io.github.plexiglasog.drink_all_you_can.client.providers.DrinkAllYouCanRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DrinkAllYouCanDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(DrinkAllYouCanModelProvider::new);
        pack.addProvider(DrinkAllYouCanRecipeProvider::new);
        pack.addProvider(DrinkAllYouCanItemTagProvider::new);
    }
}

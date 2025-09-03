package io.github.plexiglasog.drink_all_you_can;

import io.github.plexiglasog.drink_all_you_can.effect.Drink_all_you_canEffects;
import io.github.plexiglasog.drink_all_you_can.items.Drink_all_you_canItemGroups;
import io.github.plexiglasog.drink_all_you_can.items.Drink_all_you_canItems;
import net.fabricmc.api.ModInitializer;

public class Drink_all_you_can implements ModInitializer {

    public static final String MOD_ID = "drink_all_you_can";

    @Override
    public void onInitialize() {
        Drink_all_you_canItems.initialize();
        Drink_all_you_canItemGroups.initialize();
        Drink_all_you_canEffects.initialize();
    }
}

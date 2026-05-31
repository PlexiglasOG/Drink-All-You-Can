package io.github.plexiglasog.drink_all_you_can;

import io.github.plexiglasog.drink_all_you_can.effect.DrinkAllYouCanEffects;
import io.github.plexiglasog.drink_all_you_can.items.DrinkAllYouCanItemGroups;
import io.github.plexiglasog.drink_all_you_can.items.DrinkAllYouCanItems;
import net.fabricmc.api.ModInitializer;

public class DrinkAllYouCan implements ModInitializer {

    public static final String MOD_ID = "drink_all_you_can";

    @Override
    public void onInitialize() {
        DrinkAllYouCanItems.initialize();
        DrinkAllYouCanItemGroups.initialize();
        DrinkAllYouCanEffects.initialize();
    }
}

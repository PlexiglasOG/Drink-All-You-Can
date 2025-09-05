package io.github.plexiglasog.drink_all_you_can.client;

import io.github.plexiglasog.drink_all_you_can.util.Drink_all_you_canClientPackets;
import net.fabricmc.api.ClientModInitializer;

public class Drink_all_you_canClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Drink_all_you_canClientPackets.initialize();
    }
}

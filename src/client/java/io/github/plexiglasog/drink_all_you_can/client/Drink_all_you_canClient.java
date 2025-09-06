package io.github.plexiglasog.drink_all_you_can.client;

import io.github.plexiglasog.drink_all_you_can.items.Drink_all_you_canItems;
import io.github.plexiglasog.drink_all_you_can.util.Drink_all_you_canClientPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.awt.*;

public class Drink_all_you_canClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Drink_all_you_canClientPackets.initialize();

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (stack.isOf(Drink_all_you_canItems.RED_COW_CAN_EFFECTLESS) || stack.isOf(Drink_all_you_canItems.SMOKER_COLA_CAN_EFFECTLESS)) {
                lines.add(Text.translatable("item.drink_all_you_can.can_effectless.tooltip").formatted(Formatting.BLUE));
            }
        });
    }
}

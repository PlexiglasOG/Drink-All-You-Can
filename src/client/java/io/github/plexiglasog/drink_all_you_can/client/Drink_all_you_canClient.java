package io.github.plexiglasog.drink_all_you_can.client;

import io.github.plexiglasog.drink_all_you_can.items.DrinkAllYouCanItems;
import io.github.plexiglasog.drink_all_you_can.util.DrinkAllYouCanClientPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class DrinkAllYouCanClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        DrinkAllYouCanClientPackets.initialize();

        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            if (stack.isOf(DrinkAllYouCanItems.RED_COW_CAN_EFFECTLESS) || stack.isOf(DrinkAllYouCanItems.SMOKER_COLA_CAN_EFFECTLESS)) {
                lines.add(Text.translatable("item.drink_all_you_can.can_effectless.tooltip").formatted(Formatting.BLUE));
            }
        });
    }
}

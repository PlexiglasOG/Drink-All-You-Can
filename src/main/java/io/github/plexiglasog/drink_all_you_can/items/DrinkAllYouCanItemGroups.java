package io.github.plexiglasog.drink_all_you_can.items;

import io.github.plexiglasog.drink_all_you_can.DrinkAllYouCan;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DrinkAllYouCanItemGroups {
    public static final ItemGroup TEST_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DrinkAllYouCanItems.SMOKER_COLA_CAN))
            .displayName(Text.translatable("itemGroup.drink_all_you_can.drink_all_you_can_item_group"))
            .entries((context, entries) -> {
                entries.add(DrinkAllYouCanItems.BLANK_CAN);
                //Effect Cans
                entries.add(DrinkAllYouCanItems.RED_COW_CAN);
                entries.add(DrinkAllYouCanItems.SMOKER_COLA_CAN);
                //Effectless Cans
                entries.add(DrinkAllYouCanItems.RED_COW_CAN_EFFECTLESS);
                entries.add(DrinkAllYouCanItems.SMOKER_COLA_CAN_EFFECTLESS);
            })
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(DrinkAllYouCan.MOD_ID, "drink_all_you_can_item_group"), TEST_GROUP);
    }
}

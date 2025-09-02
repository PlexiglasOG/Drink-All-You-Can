package io.github.plexiglasog.drink_all_you_can.items;

import io.github.plexiglasog.drink_all_you_can.Drink_all_you_can;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Drink_all_you_canItemGroups {
    public static final ItemGroup TEST_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Drink_all_you_canItems.COCA_COLA_CAN))
            .displayName(Text.translatable("itemGroup.drink_all_you_can.drink_all_you_can_item_group"))
            .entries((context, entries) -> {
                entries.add(Drink_all_you_canItems.BLANK_CAN);
                entries.add(Drink_all_you_canItems.RED_COW_CAN);
                entries.add(Drink_all_you_canItems.COCA_COLA_CAN);
            })
            .build();
    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Drink_all_you_can.MOD_ID,"drink_all_you_can_item_group"),TEST_GROUP);
    }
}

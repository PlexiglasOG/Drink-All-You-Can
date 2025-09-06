package io.github.plexiglasog.drink_all_you_can.client.providers;

import io.github.plexiglasog.drink_all_you_can.items.Drink_all_you_canItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Drink_all_you_canRecipeProvider extends FabricRecipeProvider {
    public Drink_all_you_canRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        return new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                //Shapeless
                //Red Cow Can Effect exchange
                createShapeless(RecipeCategory.FOOD, Drink_all_you_canItems.RED_COW_CAN)
                        .input(Drink_all_you_canItems.RED_COW_CAN_EFFECTLESS)
                        .criterion(hasItem(Drink_all_you_canItems.RED_COW_CAN_EFFECTLESS), conditionsFromItem(Drink_all_you_canItems.RED_COW_CAN_EFFECTLESS))
                        .offerTo(exporter, "red_cow_can_effect_exchange_no_to_yes");
                createShapeless(RecipeCategory.FOOD, Drink_all_you_canItems.RED_COW_CAN_EFFECTLESS)
                        .input(Drink_all_you_canItems.RED_COW_CAN)
                        .criterion(hasItem(Drink_all_you_canItems.RED_COW_CAN), conditionsFromItem(Drink_all_you_canItems.RED_COW_CAN))
                        .offerTo(exporter, "red_cow_can_effect_exchange_yes_to_no");
                //SMoker Cola Effect Exchange
                createShapeless(RecipeCategory.FOOD, Drink_all_you_canItems.SMOKER_COLA_CAN)
                        .input(Drink_all_you_canItems.SMOKER_COLA_CAN_EFFECTLESS)
                        .criterion(hasItem(Drink_all_you_canItems.SMOKER_COLA_CAN_EFFECTLESS), conditionsFromItem(Drink_all_you_canItems.SMOKER_COLA_CAN_EFFECTLESS))
                        .offerTo(exporter, "smoker_cola_can_effect_exchange_no_to_yes");
                createShapeless(RecipeCategory.FOOD, Drink_all_you_canItems.SMOKER_COLA_CAN_EFFECTLESS)
                        .input(Drink_all_you_canItems.SMOKER_COLA_CAN)
                        .criterion(hasItem(Drink_all_you_canItems.SMOKER_COLA_CAN), conditionsFromItem(Drink_all_you_canItems.SMOKER_COLA_CAN))
                        .offerTo(exporter, "smoker_cola_can_effect_exchange_yes_to_no");
                //Shaped
                //THE CAN
                createShaped(RecipeCategory.MISC, Drink_all_you_canItems.BLANK_CAN, 8)
                        .pattern("s")
                        .pattern("f")
                        .pattern("s")
                        .input('s',Items.IRON_INGOT)
                        .input('f', Items.IRON_BLOCK)
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                        .offerTo(exporter);
                //Red Bull Can
                createShaped(RecipeCategory.FOOD, Drink_all_you_canItems.RED_COW_CAN)
                        .pattern("sde")
                        .pattern("aba")
                        .pattern("efs")
                        .input('s', Items.RED_DYE)
                        .input('d',Items.RED_MUSHROOM)
                        .input('f',Items.SUGAR)
                        .input('a', Items.LEATHER)
                        .input('b', Drink_all_you_canItems.BLANK_CAN)
                        .input('e', Items.BLUE_DYE)
                        .criterion(hasItem(Items.RED_MUSHROOM), conditionsFromItem(Drink_all_you_canItems.BLANK_CAN))
                        .offerTo(exporter);
                //Coca Cola Can
                createShaped(RecipeCategory.FOOD, Drink_all_you_canItems.SMOKER_COLA_CAN)
                        .pattern("sds")
                        .pattern("aba")
                        .pattern("sfs")
                        .input('s',Items.RED_DYE)
                        .input('d',Items.SMOKER)
                        .input('f',Items.SUGAR)
                        .input('a', Items.CHARCOAL)
                        .input('b', Drink_all_you_canItems.BLANK_CAN)
                        .criterion(hasItem(Items.SMOKER), conditionsFromItem(Drink_all_you_canItems.BLANK_CAN))
                        .offerTo(exporter);

                //Smelting
                offerSmelting(
                        List.of(Drink_all_you_canItems.BLANK_CAN),
                        RecipeCategory.MISC,
                        Items.IRON_INGOT,
                        0.05f,
                        51,
                        "iron_ingot_from_blank_can"
                );
            }
        };
    }



    @Override
    public String getName() {
        return "Drink_all_you_canRecipeProvider";
    }
}

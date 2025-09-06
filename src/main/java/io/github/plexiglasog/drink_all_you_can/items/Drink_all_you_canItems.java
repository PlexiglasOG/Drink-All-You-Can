package io.github.plexiglasog.drink_all_you_can.items;

import io.github.plexiglasog.drink_all_you_can.Drink_all_you_can;
import io.github.plexiglasog.drink_all_you_can.effect.Drink_all_you_canEffects;
import io.github.plexiglasog.drink_all_you_can.items.custom.CanItem;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Drink_all_you_canItems {

    //Drinks
    public static final Item RED_COW_CAN = register("red_cow_can",
            CanItem::new,
            new Item.Settings().food(new FoodComponent.Builder()
                            .nutrition(0)
                            .alwaysEdible()
                            .build(),
                    ConsumableComponents.food()
                            .sound(SoundEvents.ENTITY_GENERIC_DRINK)
                            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Drink_all_you_canEffects.RED_COW_ENERGY_EFFECT, 20*30, 0), 1.0F))
                            .build()
            )
    );
        //Effectless Variant
    public static final Item RED_COW_CAN_EFFECTLESS = register("red_cow_can_effectless",
            CanItem::new,
            new Item.Settings().food(new FoodComponent.Builder().nutrition(0).alwaysEdible().build(),
                    ConsumableComponents.food().sound(SoundEvents.ENTITY_GENERIC_DRINK).build()));

    public static final Item SMOKER_COLA_CAN = register("smoker_cola_can",
            CanItem::new,
            new Item.Settings().food(new FoodComponent.Builder()
                            .nutrition(0)
                            .alwaysEdible()
                            .build(),
                    ConsumableComponents.food()
                            .sound(SoundEvents.ENTITY_GENERIC_DRINK)
//                            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000, 1),1.0F))
//                            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5, 2),1.0F))
                            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(Drink_all_you_canEffects.SMOKER_COLA_EFFECT, 20*61, 0), 1.0F))
                            .build()
            )
    );
        //Effectless Variant
    public static final Item SMOKER_COLA_CAN_EFFECTLESS = register("smoker_cola_can_effectless",
            CanItem::new,
            new Item.Settings().food(new FoodComponent.Builder().nutrition(0).alwaysEdible().build(),
                    ConsumableComponents.food().sound(SoundEvents.ENTITY_GENERIC_DRINK).build()));


    public static final Item BLANK_CAN = register(
            "blank_can",
            Item::new,
            new Item.Settings()
    );



    //Registering of Items
    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Drink_all_you_can.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize(){

    }
}

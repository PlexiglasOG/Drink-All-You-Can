package io.github.plexiglasog.drink_all_you_can.effect;

import io.github.plexiglasog.drink_all_you_can.Drink_all_you_can;
import io.github.plexiglasog.drink_all_you_can.effect.custom.RedCowEnergyEffect;
import io.github.plexiglasog.drink_all_you_can.effect.custom.RedCowEnergyGoldEffect;
import io.github.plexiglasog.drink_all_you_can.effect.custom.SmokerColaEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class Drink_all_you_canEffects {

    public static final RegistryEntry<StatusEffect> RED_COW_ENERGY_EFFECT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Drink_all_you_can.MOD_ID, "red_cow_energy_effect"), new RedCowEnergyEffect());
    public static final RegistryEntry<StatusEffect> RED_COW_ENERGY_GOLD_EFFECT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Drink_all_you_can.MOD_ID, "red_cow_energy_gold_effect"), new RedCowEnergyGoldEffect());
    public static final RegistryEntry<StatusEffect> SMOKER_COLA_EFFECT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Drink_all_you_can.MOD_ID, "smoker_cola_effect"), new SmokerColaEffect());

    public static void initialize(){
    }
}

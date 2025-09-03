package io.github.plexiglasog.drink_all_you_can.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class RedCowEnergyEffect extends StatusEffect {


    private int pDuration = 1000;

    private PlayerEntity player;

    public RedCowEnergyEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xe21b4d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        pDuration = duration;
        return true;
    }


    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity){
            player = (PlayerEntity) entity;
            if(!((PlayerEntity) entity).getAbilities().creativeMode){
                ((PlayerEntity) entity).getAbilities().allowFlying = true;
                ((PlayerEntity) entity).sendAbilitiesUpdate();
            }
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        if(!player.getAbilities().creativeMode) {
            player.getAbilities().allowFlying = false;
            player.sendAbilitiesUpdate();
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 1));
            if (player.getAbilities().flying) {
                player.getAbilities().flying = false;
                player.sendAbilitiesUpdate();
            }
        }
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,1));
        super.onRemoved(attributeContainer);
        player = null;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        //Add Jump Boost and Slow Falling to Player
//            entity.addStatusEffect(
//                    new StatusEffectInstance(
//                            StatusEffects.SLOW_FALLING,
//                            2,
//                            (amplifier + 1) * 4,
//                            false,
//                            false,
//                            false
//                    )
//            );
//            if (pDuration > 400) {
//                entity.addStatusEffect(
//                        new StatusEffectInstance(
//                                StatusEffects.JUMP_BOOST,
//                                2,
//                                (amplifier + 1) * 3,
//                                false,
//                                false,
//                                false
//                        )
//                );
//            }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}

package io.github.plexiglasog.drink_all_you_can.effect.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class RedCowEnergyGoldEffect extends StatusEffect {


    private PlayerEntity player;

    public RedCowEnergyGoldEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xe21b4d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration, amplifier);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
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
}
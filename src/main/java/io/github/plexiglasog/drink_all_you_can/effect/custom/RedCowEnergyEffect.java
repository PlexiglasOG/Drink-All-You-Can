package io.github.plexiglasog.drink_all_you_can.effect.custom;

import io.github.plexiglasog.drink_all_you_can.util.EffectGivenThroughAnotherPayload;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class RedCowEnergyEffect extends StatusEffect {


    public RedCowEnergyEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xe21b4d);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return super.canApplyUpdateEffect(duration,amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
    }

    @Override
    public void onRemoved(AttributeContainer attributeContainer) {
        super.onRemoved(attributeContainer);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return super.applyUpdateEffect(world, entity, amplifier);
    }

//    private void sendEffectBooleanPacket(ServerPlayerEntity player, StatusEffectInstance instance) {
//        int id = Registries.STATUS_EFFECT.getRawId(instance.getEffectType().value());
//
//        EffectGivenThroughAnotherPayload payload = new EffectGivenThroughAnotherPayload(
//                id,
//                instance.getDuration(),
//                instance.getAmplifier(),
//                instance.isAmbient(),
//                true // the flag you set
//        );
//
//        ServerPlayNetworking.send(player, payload);
//    }
}

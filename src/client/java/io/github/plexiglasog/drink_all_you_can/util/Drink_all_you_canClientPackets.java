package io.github.plexiglasog.drink_all_you_can.util;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Drink_all_you_canClientPackets {

    public static void initialize(){
//        ClientPlayNetworking.registerGlobalReceiver(EffectGivenThroughAnotherPayload.ID, (payload, context) -> {
//            MinecraftClient client = context.client();
//            client.execute(() -> {
//                if (client.player == null) return;
//
//                for (StatusEffectInstance instance : client.player.getStatusEffects()) {
//                    int effectId = Registries.STATUS_EFFECT.getRawId(instance.getEffectType().value());
//
//                    if (effectId == payload.effectId()
//                            && instance.getDuration() == payload.duration()
//                            && instance.getAmplifier() == payload.amplifier()
//                            && instance.isAmbient() == payload.ambient()) {
//
//                        ((StatusEffectGivenThroughAnotherEffectDAYCInterface) instance)
//                                .setGivenThroughAnotherEffect(payload.givenThroughAnotherEffect());
//                    }
//                }
//            });
//        });
    }
}

package io.github.plexiglasog.drink_all_you_can.util;

import io.github.plexiglasog.drink_all_you_can.Drink_all_you_can;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record EffectGivenThroughAnotherPayload() {
    //I use as example for Payload
}

//public record EffectGivenThroughAnotherPayload(
//        int effectId,
//        int duration,
//        int amplifier,
//        boolean ambient,
//        boolean givenThroughAnotherEffect
//) implements CustomPayload{
//
//    public static final CustomPayload.Id<EffectGivenThroughAnotherPayload> ID = new CustomPayload.Id<>(Identifier.of(Drink_all_you_can.MOD_ID,"effect_given_through_another_effect_boolean_payload"));
//
//    public static final PacketCodec<RegistryByteBuf, EffectGivenThroughAnotherPayload> CODEC = PacketCodec.tuple(
//            PacketCodecs.INTEGER, EffectGivenThroughAnotherPayload::effectId,
//            PacketCodecs.INTEGER, EffectGivenThroughAnotherPayload::duration,
//            PacketCodecs.INTEGER, EffectGivenThroughAnotherPayload::amplifier,
//            PacketCodecs.BOOLEAN, EffectGivenThroughAnotherPayload::ambient,
//            PacketCodecs.BOOLEAN, EffectGivenThroughAnotherPayload::givenThroughAnotherEffect,
//            EffectGivenThroughAnotherPayload::new
//    );
//
//    @Override
//    public Id<? extends CustomPayload> getId() {
//        return ID;
//    }
//}

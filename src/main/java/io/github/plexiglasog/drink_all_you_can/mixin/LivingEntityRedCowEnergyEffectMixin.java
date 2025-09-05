package io.github.plexiglasog.drink_all_you_can.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.plexiglasog.drink_all_you_can.effect.Drink_all_you_canEffects;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(LivingEntity.class)
public class LivingEntityRedCowEnergyEffectMixin {

    //Modifying the Gravity when falling with the Red Cow Energy Effect
    //We modify the returnValue of the Effective Gravity, adding our multiplier
    @ModifyReturnValue(method = "getEffectiveGravity", at = @At("RETURN"))
    private double modifyGravity(double original) {
        LivingEntity self = (LivingEntity)(Object)this;
        //checking if the entity has our effect active
        if (self.hasStatusEffect(Drink_all_you_canEffects.RED_COW_ENERGY_EFFECT)) {
            int amplifier = Objects.requireNonNull(self.getStatusEffect(Drink_all_you_canEffects.RED_COW_ENERGY_EFFECT)).getAmplifier();
            //Make the modifier smaller based on amplifier
            double modifier = amplifier == 0 ? 0.4: 0.3/amplifier;//We can't divide by 0
            //We want to stop it affecting gravity at some point
            if(modifier < 0.09){ //Max is 9% of gravity
                return original * 0.09;
            } else {
                return original * modifier;
            }
        }

        return original;
    }

    //Modifying the JumpVelocity by adding our own velocity modifier
    @ModifyReturnValue(method = "getJumpVelocity(F)F", at = @At("RETURN"))
    private float modifyJumpVelocity(float original){
        LivingEntity self = (LivingEntity)(Object)this;
        //check for my effect
        if(self.hasStatusEffect(Drink_all_you_canEffects.RED_COW_ENERGY_EFFECT)){
            int amplifier = Objects.requireNonNull(self.getStatusEffect(Drink_all_you_canEffects.RED_COW_ENERGY_EFFECT)).getAmplifier();
            //Increase modifier based on amplifier
            double modifier = amplifier==0 ? 0.09 : 0.13 * amplifier;
            return original + (float) modifier;
        }
        return original;
    }
}

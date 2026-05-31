package io.github.plexiglasog.drink_all_you_can.items.custom;

import io.github.plexiglasog.drink_all_you_can.items.DrinkAllYouCanItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CanItem extends Item {


    public CanItem(Settings settings) {
        super(settings);
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity) {
            if (!((PlayerEntity) user).getAbilities().creativeMode) {
                ItemStack blankCan = new ItemStack(DrinkAllYouCanItems.BLANK_CAN);

                if (stack.isEmpty()) {
                    return blankCan;
                } else if (!((PlayerEntity) user).getInventory().insertStack(blankCan)) {
                    ((PlayerEntity) user).dropItem(blankCan, true);
                }
            }
        }
        return result;
    }
}

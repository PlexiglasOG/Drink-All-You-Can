package io.github.plexiglasog.drink_all_you_can.effect.custom;

import io.github.plexiglasog.drink_all_you_can.Drink_all_you_can;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SmokerColaEffect extends StatusEffect {

    public static final TagKey<Item> DRINK_ALL_YOU_CAN_RAW_MEAT = TagKey.of(RegistryKeys.ITEM, Identifier.of(Drink_all_you_can.MOD_ID, "drink_all_you_can_raw_meat"));

    private final Random random = new Random();

    public SmokerColaEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xAE0001);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        //Only cook meat in inventory of Player
        if(entity instanceof PlayerEntity){
            //Only run code server-side to avoid Crashing
            if (entity.getWorld() instanceof ServerWorld serverWorld) {
                //Get all Items from the tag "DRINK_ALL_YOU_CAN_RAW_MEAT"
                List<Item> items = Registries.ITEM.streamEntries()
                        .filter(entry -> entry.isIn(DRINK_ALL_YOU_CAN_RAW_MEAT))
                        .map(RegistryEntry::value)
                        .toList();

                //Get Inventory of Player
                PlayerInventory playerInventory = ((PlayerEntity) entity).getInventory();
                //Create List for all Slots
                List<Integer> slotsWithRawMeat = new ArrayList<>();
                //Iterate all Items in Tag and add all Slots with that item into the SlotList
                for (Item item : items) {
                    slotsWithRawMeat.addAll(getSlotsWithItemStack(playerInventory, new ItemStack(item)));
                }
                //It not empty there is meat to smoke
                if(!slotsWithRawMeat.isEmpty()){
                    //Get a random Slot from the List
                    int randomSlot = slotsWithRawMeat.get(random.nextInt(0,slotsWithRawMeat.size()));
                    //Get the ItemStack in that slot and copy it
                    ItemStack rawMeatStack = playerInventory.getStack(randomSlot);
                    ItemStack rawMeatStackCopy = rawMeatStack.copy();
                    // get its stack size
                    int stackSize = rawMeatStack.getCount();
                    //Take away the amount of meat that corresponds to Effect Level or all of it if Level exceeds stack size
                    rawMeatStack.decrement(Math.min(amplifier+1, stackSize));
                    //Insert Meat :>
                    playerInventory.offerOrDrop(getSmokedVariant(serverWorld, rawMeatStackCopy, Math.min(amplifier+1, stackSize)));
                }
            }
        }
        super.onApplied(entity, amplifier);
    }

    private List<Integer> getSlotsWithItemStack(PlayerInventory playerInventory, ItemStack itemStack){
        List<Integer> slotList = new ArrayList<>();
        for(int i = 0;i < playerInventory.size(); i++ ){
            ItemStack current = playerInventory.getStack(i);
            if(!current.isEmpty() && ItemStack.areItemsAndComponentsEqual(itemStack, current)){
                slotList.add(i);
            }
        }
        return slotList;
    }

    private ItemStack getSmokedVariant(ServerWorld world, ItemStack inputToCopy, int returnCount) {
        // Wrap your ItemStack in a SingleStackRecipeInput
        ItemStack input = inputToCopy.copy();
        SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(input);

        // Use getFirstMatch to find the first matching smoking recipe
        Optional<RecipeEntry<SmokingRecipe>> optionalRecipe =
                world.getRecipeManager().getFirstMatch(RecipeType.SMOKING, recipeInput, world);

        // If a recipe is found, craft it
        if (optionalRecipe.isPresent()) {
            SmokingRecipe recipe = optionalRecipe.get().value();
            ItemStack output = recipe.craft(recipeInput, world.getRegistryManager());
            //Return amount of smoked meat based on size
            //Don't allow counts bigger than 64
            if(returnCount>input.getMaxCount()){returnCount = input.getMaxCount();}
            //Set Count of Items in Stacks to return count
            output.setCount(returnCount);
            return  output;
        }

        return ItemStack.EMPTY;
    }

}

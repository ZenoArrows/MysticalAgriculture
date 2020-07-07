package com.blakebr0.mysticalagriculture.api.soul;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

/**
 * Implement this interface on items that give mob souls when used to kill mobs
 */
public interface ISoulSiphoningItem {
    /**
     * Get the amount of souls obtained from killing this entity with this item
     * @param stack the item used to kill this entity
     * @param entity the entity killed
     * @return the amount of souls siphoned
     */
    double getSiphonAmount(ItemStack stack, LivingEntity entity);
}

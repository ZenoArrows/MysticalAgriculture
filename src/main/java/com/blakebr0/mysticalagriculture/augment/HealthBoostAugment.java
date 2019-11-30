package com.blakebr0.mysticalagriculture.augment;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagriculture.api.tinkering.Augment;
import com.blakebr0.mysticalagriculture.api.tinkering.AugmentType;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.EnumSet;
import java.util.UUID;

public class HealthBoostAugment extends Augment {
    private static final UUID ATTRIBUTE_ID = UUID.fromString("e04addf9-0fe8-4498-b5a8-45e5201cd76d");
    private final int amplifier;

    public HealthBoostAugment(ResourceLocation id, int tier, int amplifier) {
        super(id, tier, EnumSet.of(AugmentType.ARMOR), getColor(0xC6223B, tier), getColor(0x3B0402, tier));
        this.amplifier = amplifier;
    }

    @Override
    public void addArmorAttributeModifiers(Multimap<String, AttributeModifier> attributes, EquipmentSlotType slot, ItemStack stack) {
        attributes.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(ATTRIBUTE_ID, "generic.maxHealth", 4 * this.amplifier, AttributeModifier.Operation.ADDITION));
    }

    public static int getColor(int color, int tier) {
        return Utils.saturate(color, Math.min((float) tier / 5, 1));
    }
}
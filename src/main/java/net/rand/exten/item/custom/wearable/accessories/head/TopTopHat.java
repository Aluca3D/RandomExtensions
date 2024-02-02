package net.rand.exten.item.custom.wearable.accessories.head;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rand.exten.item.custom.wearable.Hats;

public class TopTopHat extends Hats {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public TopTopHat(Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Accessory modifier", 1, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier("Accessory modifier", 2, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.HEAD) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }

    @Override
    public void SpecialAbility(PlayerEntity user, ItemStack stack, World world) {

    }
}

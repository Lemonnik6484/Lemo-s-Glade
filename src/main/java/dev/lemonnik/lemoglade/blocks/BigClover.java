package dev.lemonnik.lemoglade.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BigClover extends FlowerBlock {
    public BigClover(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);

        if (world.isClient) return;

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 30));
        }
    }
}

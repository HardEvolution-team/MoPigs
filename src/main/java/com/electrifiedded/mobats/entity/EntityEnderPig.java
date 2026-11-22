package com.electrifiedded.mobats.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityEnderPig extends EntityEnderman {
    public EntityEnderPig(World w) {
        super(w);
        setSize(0.9F, 0.9F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0);
    }

    @Override
    public float getEyeHeight() { return 0.7F; }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_PIG_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) { return SoundEvents.ENTITY_PIG_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_PIG_DEATH; }
}

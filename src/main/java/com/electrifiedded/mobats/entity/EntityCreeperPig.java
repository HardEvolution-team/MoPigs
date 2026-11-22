package com.electrifiedded.mobats.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCreeperPig extends EntityCreeper {
    public EntityCreeperPig(World w) {
        super(w);
        setSize(0.9F, 0.9F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
    }

    @Override
    public float getEyeHeight() { return 0.7F; }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_PIG_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) { return SoundEvents.ENTITY_CREEPER_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_CREEPER_DEATH; }
}

package com.electrifiedded.mobats.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/** Evil pig: angry-when-hit pig zombie with a pig body (original EavilPig / EntityBloodBat). */
public class EntityBloodBat extends EntityPigZombie {
    public EntityBloodBat(World w) {
        super(w);
        setSize(0.9F, 0.9F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.5);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0);
    }

    @Override
    public float getEyeHeight() { return 0.7F; }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_PIG_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) { return SoundEvents.ENTITY_PIG_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_PIG_DEATH; }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        dropItem(Items.ROTTEN_FLESH, 1);
        dropItem(Items.COOKED_PORKCHOP, 1);
        if (recent && rand.nextInt(Math.max(1, 40 - looting * 10)) == 0) dropItem(Items.GOLD_INGOT, 1);
    }
}

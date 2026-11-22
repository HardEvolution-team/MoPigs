package com.electrifiedded.mobats.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;

public class EntitySnowPig extends EntityPig {
    public EntitySnowPig(World w) { super(w); }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0);
    }

    @Override
    public EntityPig createChild(EntityAgeable p) { return new EntitySnowPig(world); }
}

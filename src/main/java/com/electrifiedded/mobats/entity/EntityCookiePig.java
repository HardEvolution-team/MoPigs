package com.electrifiedded.mobats.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** Nether pig with 50 HP that lays eggs. */
public class EntityCookiePig extends EntityPig {
    public int timeUntilNextEgg;

    public EntityCookiePig(World w) {
        super(w);
        timeUntilNextEgg = rand.nextInt(600) + 600;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!world.isRemote && !isChild() && --timeUntilNextEgg <= 0) {
            playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
            dropItem(Items.EGG, 1);
            timeUntilNextEgg = rand.nextInt(600) + 600;
        }
    }

    @Override
    public float getBlockPathWeight(BlockPos pos) { return 0.0F; }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos p = new BlockPos(posX, getEntityBoundingBox().minY, posZ);
        return world.getBlockState(p.down()).getMaterial().isSolid()
                && world.getCollisionBoxes(this, getEntityBoundingBox()).isEmpty()
                && !world.containsAnyLiquid(getEntityBoundingBox());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound t) {
        super.writeEntityToNBT(t);
        t.setInteger("EggLayTime", timeUntilNextEgg);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound t) {
        super.readEntityFromNBT(t);
        if (t.hasKey("EggLayTime")) timeUntilNextEgg = t.getInteger("EggLayTime");
    }

    @Override
    public EntityPig createChild(EntityAgeable p) { return new EntityCookiePig(world); }
}

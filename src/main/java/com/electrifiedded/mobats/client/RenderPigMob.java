package com.electrifiedded.mobats.client;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderPigMob extends RenderLiving<EntityLiving> {
    private final ResourceLocation tex;

    public RenderPigMob(RenderManager m, String texture) {
        super(m, new ModelPig(), 0.3F);
        this.tex = new ResourceLocation(texture);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving e) { return tex; }
}

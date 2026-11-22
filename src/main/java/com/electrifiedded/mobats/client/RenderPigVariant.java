package com.electrifiedded.mobats.client;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderPigVariant extends RenderPig {
    private final ResourceLocation tex;

    public RenderPigVariant(RenderManager m, String texture) {
        super(m);
        this.tex = new ResourceLocation(texture);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPig e) { return tex; }
}

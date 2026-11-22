package com.electrifiedded.mobats.client;

import com.electrifiedded.mobats.CommonProxy;
import com.electrifiedded.mobats.entity.*;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    private static final String D = "mobats:textures/mobs/";

    @Override
    public void preInit() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowPig.class, m -> new RenderPigVariant(m, D + "snowpig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityCookiePig.class, m -> new RenderPigVariant(m, D + "cookiepig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodBat.class, m -> new RenderPigMob(m, D + "eavilpig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombiePigZ.class, m -> new RenderPigMob(m, D + "zombiepig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonPig.class, m -> new RenderPigMob(m, D + "skeletonpig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderPig.class, m -> new RenderPigMob(m, D + "enderpig.png"));
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperPig.class, m -> new RenderPigMob(m, D + "creeperpig.png"));
    }
}

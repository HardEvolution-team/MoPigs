package com.electrifiedded.mobats;

import com.electrifiedded.archaiclib.legacy.registry.LegacyGameRegistry;
import com.electrifiedded.archaiclib.legacy.world.LegacySpawns;
import com.electrifiedded.archaiclib.original.OriginalModAssets;
import com.electrifiedded.mobats.entity.*;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/** Mo Pigs Mod (original modid "mobats", 1.7.10 by bigboom) - clean-room reimplementation for 1.12.2. */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:archaiclib")
public class MoPigs {
    public static final String ORIGINAL_NAME = "mo_pigs_1.0.jar - Mo Pigs Mod 1.0 for 1.7.10 (by bigboom)";
    public static final String ORIGINAL_URL = "https://www.curseforge.com/minecraft/mc-mods (search: Mo Pigs Mod)";

    @Mod.Instance(Reference.MOD_ID)
    public static MoPigs instance;

    @SidedProxy(clientSide = "com.electrifiedded.mobats.client.ClientProxy", serverSide = "com.electrifiedded.mobats.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        OriginalModAssets.require(Reference.MOD_ID, Reference.MOD_ID, ORIGINAL_NAME, ORIGINAL_URL, Reference.MOD_ID);
        int id = 0;
        LegacyGameRegistry.registerModEntity(EntityBloodBat.class, "EavilPig", id++, this, 64, 1, true, 4859403, 13182734);
        LegacyGameRegistry.registerModEntity(EntitySnowPig.class, "SnowPig", id++, this, 64, 1, true, 14153719, 390645);
        LegacyGameRegistry.registerModEntity(EntityCookiePig.class, "CookiePig", id++, this, 64, 1, true, 13663780, 9260551);
        LegacyGameRegistry.registerModEntity(EntityZombiePigZ.class, "ZombiePigZ", id++, this, 64, 1, true, 1525016, 1604891);
        LegacyGameRegistry.registerModEntity(EntitySkeletonPig.class, "SkeletonPig", id++, this, 64, 1, true, 10263708, 16579319);
        LegacyGameRegistry.registerModEntity(EntityEnderPig.class, "Enderpig", id++, this, 64, 1, true, 3289907, 15076602);
        LegacyGameRegistry.registerModEntity(EntityCreeperPig.class, "CreeperPig", id++, this, 64, 1, true, 1395983, 3255076);

        // original: snow pig in plains, the rest in the Nether, all as creatures (evil pig: egg only)
        EnumCreatureType c = EnumCreatureType.CREATURE;
        LegacySpawns.addSpawn(EntitySnowPig.class, 15, 3, 7, c, Biomes.PLAINS);
        LegacySpawns.addSpawn(EntityCookiePig.class, 15, 3, 7, c, Biomes.HELL);
        LegacySpawns.addSpawn(EntityZombiePigZ.class, 15, 3, 7, c, Biomes.HELL);
        LegacySpawns.addSpawn(EntitySkeletonPig.class, 15, 3, 7, c, Biomes.HELL);
        LegacySpawns.addSpawn(EntityEnderPig.class, 15, 3, 7, c, Biomes.HELL);
        LegacySpawns.addSpawn(EntityCreeperPig.class, 15, 3, 7, c, Biomes.HELL);
        proxy.preInit();
    }
}

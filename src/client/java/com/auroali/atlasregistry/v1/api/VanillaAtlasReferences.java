package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.VanillaSpriteAtlasReference;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;

/**
 * Atlas references for vanilla built-in atlases
 */
public class VanillaAtlasReferences {
    public static final SpriteAtlasReference BLOCKS = new VanillaSpriteAtlasReference(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
    public static final SpriteAtlasReference PARTICLES = new VanillaSpriteAtlasReference(SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
    public static final SpriteAtlasReference ARMOR_TRIMS = new VanillaSpriteAtlasReference(TexturedRenderLayers.ARMOR_TRIMS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference BEDS = new VanillaSpriteAtlasReference(TexturedRenderLayers.BEDS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference BANNER_PATTERNS = new VanillaSpriteAtlasReference(TexturedRenderLayers.BANNER_PATTERNS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference CHEST = new VanillaSpriteAtlasReference(TexturedRenderLayers.CHEST_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SIGNS = new VanillaSpriteAtlasReference(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference DECORATED_POT = new VanillaSpriteAtlasReference(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SHULKER_BOXES = new VanillaSpriteAtlasReference(TexturedRenderLayers.SHULKER_BOXES_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SHIELD_PATTERNS = new VanillaSpriteAtlasReference(TexturedRenderLayers.SHIELD_PATTERNS_ATLAS_TEXTURE);
}

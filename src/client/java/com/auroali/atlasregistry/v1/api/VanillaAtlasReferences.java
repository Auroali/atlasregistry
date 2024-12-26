package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.texture.SpriteAtlasTexture;

/**
 * Atlas references for vanilla built-in atlases
 * <br> These <i>should not</i> be registered in the atlas registry!
 */
public class VanillaAtlasReferences {
    public static final SpriteAtlasReference BLOCKS = SpriteAtlasReference.reference(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
    public static final SpriteAtlasReference PARTICLES = SpriteAtlasReference.reference(SpriteAtlasTexture.PARTICLE_ATLAS_TEXTURE);
    public static final SpriteAtlasReference ARMOR_TRIMS = SpriteAtlasReference.reference(TexturedRenderLayers.ARMOR_TRIMS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference BEDS = SpriteAtlasReference.reference(TexturedRenderLayers.BEDS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference BANNER_PATTERNS = SpriteAtlasReference.reference(TexturedRenderLayers.BANNER_PATTERNS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference CHEST = SpriteAtlasReference.reference(TexturedRenderLayers.CHEST_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SIGNS = SpriteAtlasReference.reference(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE);
    public static final SpriteAtlasReference DECORATED_POT = SpriteAtlasReference.reference(TexturedRenderLayers.DECORATED_POT_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SHULKER_BOXES = SpriteAtlasReference.reference(TexturedRenderLayers.SHULKER_BOXES_ATLAS_TEXTURE);
    public static final SpriteAtlasReference SHIELD_PATTERNS = SpriteAtlasReference.reference(TexturedRenderLayers.SHIELD_PATTERNS_ATLAS_TEXTURE);
}

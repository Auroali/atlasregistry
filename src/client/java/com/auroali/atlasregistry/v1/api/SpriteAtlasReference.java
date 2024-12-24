package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public interface SpriteAtlasReference {
    /**
     * @return the id of this atlas
     */
    Identifier getId();

    /**
     * @return the texture for the referenced atlas
     */
    Identifier getTexture();

    /**
     * @return the texture atlas that this object references
     */
    SpriteAtlasTexture getAtlas();

    /**
     * @return the mip level of the referenced atlas
     */
    int getMipLevel();

    /**
     * triggers the reload callback
     */
    void reload();

    /**
     * @param id the id of the sprite
     * @return the sprite contained in the referenced atlas with the specified id
     */
    Sprite getSprite(Identifier id);

    /**
     * Creates a sprite identifier for the referenced atlas
     * @param id the id of the sprite
     * @return the sprite identifier for the sprite
     */
    SpriteIdentifier createSpriteIdentifier(Identifier id);
}

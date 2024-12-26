package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.ExistingSpriteAtlasReference;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

/**
 * Represents a reference to a SpriteAtlasTexture. Also provides utility functions,
 * such as getting the width and height of an atlas or getting a sprite/creating a sprite identifier.
 * @see AtlasRegistry
 * @see VanillaAtlasReferences
 */
public interface SpriteAtlasReference {
    /**
     * References an existing atlas. Do not register this!
     * @param id the texture path of the atlas to reference (ex. "minecraft:textures/atlas/blocks.png")
     * @return an atlas reference referencing the specified atlas texture
     * @see VanillaAtlasReferences
     */
    static SpriteAtlasReference reference(Identifier id) {
        return new ExistingSpriteAtlasReference(id);
    }

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
     * @return the width of the referenced atlas' texture
     */
    int getWidth();

    /**
     * @return the height of the referenced atlas' texture
     */
    int getHeight();

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

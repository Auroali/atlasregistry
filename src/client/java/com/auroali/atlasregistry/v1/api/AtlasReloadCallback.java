package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

/**
 * A callback that is run on an atlas reference whenever the stored atlas is reloaded.
 * It is safe to assume that the referenced atlas has already been initialized when this is triggered
 */
public interface AtlasReloadCallback {
    /**
     * An empty atlas reload callback. This is used when no other callback is specified
     */
    AtlasReloadCallback EMPTY = (identifier, atlas) -> {};

    /**
     * The reload callback
     * @param identifier the id of the atlas
     * @param atlas the atlas reference
     */
    void onReload(Identifier identifier, SpriteAtlasReference atlas);
}

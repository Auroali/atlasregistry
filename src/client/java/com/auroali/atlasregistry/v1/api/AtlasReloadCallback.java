package com.auroali.atlasregistry.v1.api;

import net.minecraft.util.Identifier;

/**
 * A callback that is run on an atlas reference whenever the stored atlas is reloaded.
 * It is safe to assume that the referenced atlas has already been initialized when this is triggered
 * @since 1.0.0
 */
public interface AtlasReloadCallback {
    /**
     * An empty atlas reload callback. This is used when no other callback is specified
     * @since 1.0.0
     */
    AtlasReloadCallback EMPTY = (identifier, atlas) -> {};

    /**
     * The reload callback
     * @param identifier the id of the atlas
     * @param atlas the atlas reference
     * @since 1.0.0
     */
    void onReload(Identifier identifier, SpriteAtlasReference atlas);
}

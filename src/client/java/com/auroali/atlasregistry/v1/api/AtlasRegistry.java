package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.AtlasRegistryImpl;

import java.util.Objects;

public class AtlasRegistry {
    /**
     * Registers a texture atlas
     * @param atlas the atlas reference to be registered
     */
    public static void register(SpriteAtlasReference atlas) {
        Objects.requireNonNull(atlas);
        AtlasRegistryImpl.register(atlas);
    }
}

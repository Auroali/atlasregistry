package com.auroali.altasregistry.v1.api;

import com.auroali.altasregistry.v1.impl.AtlasRegistryImpl;

import java.util.Objects;

public class AtlasRegistry {
    public static void register(SpriteAtlasReference atlas) {
        Objects.requireNonNull(atlas);
        AtlasRegistryImpl.register(atlas);
    }
}

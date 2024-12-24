package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.AtlasRegistryImpl;
import net.minecraft.util.Identifier;

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

    /**
     * Returns a registered atlas
     * @param id the id of the atlas
     * @return the sprite atlas reference for the given id, or null if it doesn't exist
     */
    public static SpriteAtlasReference get(Identifier id) {
        return AtlasRegistryImpl.ATLASES.get(id);
    }
}

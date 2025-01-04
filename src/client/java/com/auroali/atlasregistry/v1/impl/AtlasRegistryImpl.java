package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AtlasRegistryImpl {
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES = new HashMap<>();
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES_BY_TEXTURE = new HashMap<>();
    public static boolean frozen;

    public static void register(SpriteAtlasReference reference) {
        if(reference instanceof ExistingSpriteAtlasReference)
            throw new IllegalArgumentException("Could not register atlas " + reference.getId() + ": Tried registering an ExistingSpriteAtlasReference to the atlas registry");

        if(frozen)
            throw new RuntimeException("Could not register atlas " + reference.getId() + ": Registry is frozen");

        if(ATLASES.containsKey(reference.getId()))
            throw new RuntimeException("Could not register atlas " + reference.getId() + ": ID is already present in the registry");

        ATLASES.put(reference.getId(), reference);
        ATLASES_BY_TEXTURE.put(reference.getTexture(), reference);
    }

    public static void freeze() {
        frozen = true;
    }
}

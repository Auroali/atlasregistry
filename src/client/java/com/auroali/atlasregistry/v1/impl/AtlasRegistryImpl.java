package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AtlasRegistryImpl {
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES = new HashMap<>();
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES_BY_TEXTURE = new HashMap<>();

    public static void register(SpriteAtlasReference reference) {
        if(reference instanceof VanillaSpriteAtlasReference)
            throw new IllegalArgumentException("Tried registering a VanillaSpriteAtlasReference to the atlas registry");

        if(ATLASES.containsKey(reference.getId()))
            throw new RuntimeException("Atlas " + reference.getId() + " is already present in the registry.");


        ATLASES.put(reference.getId(), reference);
        ATLASES_BY_TEXTURE.put(reference.getTexture(), reference);
    }
}

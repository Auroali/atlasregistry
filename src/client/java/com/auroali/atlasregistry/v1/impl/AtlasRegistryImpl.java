package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.api.VanillaAtlasReferences;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AtlasRegistryImpl {
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES = new HashMap<>();
    public static void register(SpriteAtlasReference reference) {
        if(reference instanceof VanillaSpriteAtlasReference)
            throw new IllegalArgumentException("Tried registering a VanillaSpriteAtlasReference to the atlas registry");

        ATLASES.put(reference.getId(), reference);
    }
}

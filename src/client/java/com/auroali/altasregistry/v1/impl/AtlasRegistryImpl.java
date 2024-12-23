package com.auroali.altasregistry.v1.impl;

import com.auroali.altasregistry.v1.api.SpriteAtlasReference;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class AtlasRegistryImpl {
    public static final HashMap<Identifier, SpriteAtlasReference> ATLASES = new HashMap<>();
    public static void register(SpriteAtlasReference reference) {
        ATLASES.put(reference.getId(), reference);
    }
}

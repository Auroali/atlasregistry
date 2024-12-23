package com.auroali.altasregistry.v1.api;

import com.auroali.altasregistry.v1.impl.SpriteAtlasReferenceBuilderImpl;
import net.minecraft.util.Identifier;

public interface SpriteAtlasReferenceBuilder {
    static SpriteAtlasReferenceBuilder create(Identifier id) {
        return new SpriteAtlasReferenceBuilderImpl(id);
    }

    SpriteAtlasReferenceBuilder mipLevel(int level);
    SpriteAtlasReferenceBuilder reloadCallback(AtlasReloadCallback callback);
    SpriteAtlasReference build();
}

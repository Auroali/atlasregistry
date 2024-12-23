package com.auroali.altasregistry.v1.impl;

import com.auroali.altasregistry.v1.api.AtlasReloadCallback;
import com.auroali.altasregistry.v1.api.SpriteAtlasReference;
import com.auroali.altasregistry.v1.api.SpriteAtlasReferenceBuilder;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class SpriteAtlasReferenceBuilderImpl implements SpriteAtlasReferenceBuilder {
    final Identifier id;
    int mipLevel;
    AtlasReloadCallback reloadCallback;

    public SpriteAtlasReferenceBuilderImpl(Identifier id) {
        this.id = id;
        this.mipLevel = 0;
        this.reloadCallback = AtlasReloadCallback.EMPTY;
    }
    @Override
    public SpriteAtlasReferenceBuilder mipLevel(int level) {
        this.mipLevel = level;
        return this;
    }

    @Override
    public SpriteAtlasReferenceBuilder reloadCallback(AtlasReloadCallback callback) {
        this.reloadCallback = callback;
        return this;
    }

    @Override
    public SpriteAtlasReference build() {
        Objects.requireNonNull(this.id);
        Objects.requireNonNull(this.reloadCallback);
        return new SpriteAtlasReferenceImpl(this.id, this.mipLevel, this.reloadCallback);
    }
}

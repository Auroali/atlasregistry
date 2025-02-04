package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.AtlasReloadCallback;
import com.auroali.atlasregistry.v1.api.CustomSpriteAtlasLoader;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReferenceBuilder;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.function.IntSupplier;

public class SpriteAtlasReferenceBuilderImpl implements SpriteAtlasReferenceBuilder {
    final Identifier id;
    IntSupplier mipLevel;
    AtlasReloadCallback reloadCallback;
    CustomSpriteAtlasLoader loader;

    public SpriteAtlasReferenceBuilderImpl(Identifier id) {
        this.id = id;
        this.mipLevel = () -> 0;
        this.reloadCallback = AtlasReloadCallback.EMPTY;
        this.loader = CustomSpriteAtlasLoader.DEFAULT;
    }

    @Override
    public SpriteAtlasReferenceBuilder mipLevel(int level) {
        this.mipLevel = () -> level;
        return this;
    }

    @Override
    public SpriteAtlasReferenceBuilder mipLevel(IntSupplier levelSupper) {
        this.mipLevel = levelSupper;
        return this;
    }

    @Override
    public SpriteAtlasReferenceBuilder reloadCallback(AtlasReloadCallback callback) {
        this.reloadCallback = callback;
        return this;
    }

    @Override
    public SpriteAtlasReferenceBuilder loader(CustomSpriteAtlasLoader loader) {
        this.loader = loader;
        return this;
    }

    @Override
    public SpriteAtlasReference build() {
        Objects.requireNonNull(this.id);
        Objects.requireNonNull(this.reloadCallback);
        Objects.requireNonNull(this.mipLevel);
        Objects.requireNonNull(this.loader);
        return new SpriteAtlasReferenceImpl(this.id, this.mipLevel, this.reloadCallback, loader);
    }
}

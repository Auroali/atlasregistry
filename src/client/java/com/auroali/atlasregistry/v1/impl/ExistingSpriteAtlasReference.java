package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.CustomSpriteAtlasLoader;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.mixin.SpriteAtlasTextureAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ExistingSpriteAtlasReference implements SpriteAtlasReference {
    final Identifier textureId;

    public ExistingSpriteAtlasReference(Identifier id) {
        this.textureId = id;
    }

    @Override
    public Identifier getId() {
        return this.textureId;
    }

    @Override
    public Identifier getTexture() {
        return this.textureId;
    }

    @Override
    public SpriteAtlasTexture getAtlas() {
        return MinecraftClient.getInstance().getBakedModelManager().getAtlas(this.textureId);
    }

    @Override
    public int getWidth() {
        return ((SpriteAtlasTextureAccessor)getAtlas()).atlasregistry$getWidth();
    }

    @Override
    public int getHeight() {
        return ((SpriteAtlasTextureAccessor)getAtlas()).atlasregistry$getHeight();
    }

    @Override
    public int getMipLevel() {
        return ((SpriteAtlasTextureAccessor)getAtlas()).atlasregistry$getMipLevel();
    }

    @Override
    public void reload() {}

    @Override
    public Sprite getSprite(Identifier id) {
        return getAtlas().getSprite(id);
    }

    @Override
    public Collection<Sprite> getSprites() {
        return ((SpriteAtlasTextureAccessor)this.getAtlas()).atlasregistry$getSprites().values();
    }

    @Override
    public SpriteIdentifier createSpriteIdentifier(Identifier id) {
        return new SpriteIdentifier(this.textureId, id);
    }

    @Override
    public CustomSpriteAtlasLoader getLoader() {
        return CustomSpriteAtlasLoader.NOOP;
    }

    @Override
    public Iterator<Sprite> iterator() {
        return ((SpriteAtlasTextureAccessor)this.getAtlas()).atlasregistry$getSprites().values().iterator();
    }

    @Override
    public void forEach(Consumer<? super Sprite> action) {
        ((SpriteAtlasTextureAccessor)this.getAtlas()).atlasregistry$getSprites().values().forEach(action);
    }

    @Override
    public Spliterator<Sprite> spliterator() {
        return ((SpriteAtlasTextureAccessor)this.getAtlas()).atlasregistry$getSprites().values().spliterator();
    }
}

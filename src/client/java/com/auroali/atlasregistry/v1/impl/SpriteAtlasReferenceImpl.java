package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.AtlasReloadCallback;
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
import java.util.function.IntSupplier;

public class SpriteAtlasReferenceImpl implements SpriteAtlasReference {
    protected SpriteAtlasTexture texture;
    protected final Identifier id;
    protected final Identifier texturePath;
    protected final AtlasReloadCallback callback;
    protected final IntSupplier mipLevel;
    protected final CustomSpriteAtlasLoader loader;

    public SpriteAtlasReferenceImpl(Identifier id, IntSupplier mipLevel, AtlasReloadCallback callback, CustomSpriteAtlasLoader loader) {
        this.id = id;
        this.texturePath = id.withPath(string -> "textures/atlas/" + string + ".png");
        this.callback = callback;
        this.mipLevel = mipLevel;
        this.loader = loader;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public Identifier getTexture() {
        return this.texturePath;
    }

    @Override
    public SpriteAtlasTexture getAtlas() {
        if (this.texture == null) {
            this.texture = new SpriteAtlasTexture(this.texturePath);
            MinecraftClient.getInstance().getTextureManager().registerTexture(this.texturePath, this.texture);
        }
        return this.texture;
    }

    @Override
    public int getWidth() {
        return ((SpriteAtlasTextureAccessor) getAtlas()).atlasregistry$getWidth();
    }

    @Override
    public int getHeight() {
        return ((SpriteAtlasTextureAccessor) getAtlas()).atlasregistry$getHeight();
    }

    @Override
    public int getMipLevel() {
        return this.mipLevel.getAsInt();
    }

    @Override
    public void reload() {
        this.callback.onReload(this.id, this);
    }

    @Override
    public Sprite getSprite(Identifier id) {
        return this.getAtlas().getSprite(id);
    }

    @Override
    public Collection<Sprite> getSprites() {
        return ((SpriteAtlasTextureAccessor) this.getAtlas()).atlasregistry$getSprites().values();
    }

    @Override
    public SpriteIdentifier createSpriteIdentifier(Identifier id) {
        return new SpriteIdentifier(this.texturePath, id);
    }

    @Override
    public CustomSpriteAtlasLoader getLoader() {
        return this.loader;
    }

    @Override
    public Iterator<Sprite> iterator() {
        return ((SpriteAtlasTextureAccessor) this.getAtlas()).atlasregistry$getSprites().values().iterator();
    }

    @Override
    public void forEach(Consumer<? super Sprite> action) {
        ((SpriteAtlasTextureAccessor) this.getAtlas()).atlasregistry$getSprites().values().forEach(action);
    }

    @Override
    public Spliterator<Sprite> spliterator() {
        return ((SpriteAtlasTextureAccessor) this.getAtlas()).atlasregistry$getSprites().values().spliterator();
    }
}

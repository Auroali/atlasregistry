package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.mixin.SpriteAtlasTextureAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class VanillaSpriteAtlasReference implements SpriteAtlasReference {
    final Identifier textureId;

    public VanillaSpriteAtlasReference(Identifier id) {
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
    public SpriteIdentifier createSpriteIdentifier(Identifier id) {
        return new SpriteIdentifier(this.textureId, id);
    }
}

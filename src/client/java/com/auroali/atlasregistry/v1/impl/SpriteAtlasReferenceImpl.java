package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.AtlasReloadCallback;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class SpriteAtlasReferenceImpl implements SpriteAtlasReference {
    protected SpriteAtlasTexture texture;
    protected final Identifier id;
    protected final Identifier texturePath;
    protected final AtlasReloadCallback callback;
    protected final int mipLevel;

    public SpriteAtlasReferenceImpl(Identifier id, int mipLevel, AtlasReloadCallback callback) {
        this.id = id;
        this.texturePath = id.withPath(string -> "textures/atlas/" + string + ".png");
        this.callback = callback;
        this.mipLevel = mipLevel;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public SpriteAtlasTexture getAtlas() {
        if(this.texture == null) {
            this.texture = new SpriteAtlasTexture(this.texturePath);
            MinecraftClient.getInstance().getTextureManager().registerTexture(this.texturePath, this.texture);
        }
        return this.texture;
    }

    @Override
    public int getMipLevel() {
        return this.mipLevel;
    }

    @Override
    public void reload() {
        this.callback.onReload(this.id, this.getAtlas());
    }

    @Override
    public Sprite getSprite(Identifier id) {
        return this.getAtlas().getSprite(id);
    }

    @Override
    public SpriteIdentifier createSpriteIdentifier(Identifier id) {
        return new SpriteIdentifier(this.texturePath, id);
    }
}

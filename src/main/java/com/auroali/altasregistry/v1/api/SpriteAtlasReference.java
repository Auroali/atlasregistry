package com.auroali.altasregistry.v1.api;

import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public interface SpriteAtlasReference {
    Identifier getId();
    SpriteAtlasTexture getAtlas();
    int getMipLevel();
    void reload();
    Sprite getSprite(Identifier id);
}

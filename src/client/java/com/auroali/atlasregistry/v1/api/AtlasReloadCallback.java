package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public interface AtlasReloadCallback {
    AtlasReloadCallback EMPTY = (identifier, atlas) -> {};
    void onReload(Identifier identifier, SpriteAtlasTexture atlas);
}

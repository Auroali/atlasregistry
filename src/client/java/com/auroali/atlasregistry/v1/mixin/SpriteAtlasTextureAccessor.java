package com.auroali.atlasregistry.v1.mixin;

import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;

@Mixin(SpriteAtlasTexture.class)
public interface SpriteAtlasTextureAccessor {
    @Accessor("mipLevel")
    int atlasregistry$getMipLevel();

    @Invoker("getWidth")
    int atlasregistry$getWidth();

    @Invoker("getHeight")
    int atlasregistry$getHeight();

    @Accessor("sprites")
    Map<Identifier, Sprite> atlasregistry$getSprites();
}

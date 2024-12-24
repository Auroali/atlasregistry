package com.auroali.atlasregistry.v1.mixin;

import net.minecraft.client.texture.SpriteAtlasTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SpriteAtlasTexture.class)
public interface SpriteAtlasTextureAccessor {
    @Accessor("mipLevel")
    int atlasregistry$getMipLevel();

    @Invoker("getWidth")
    int atlasregistry$getWidth();

    @Invoker("getHeight")
    int atlasregistry$getHeight();
}

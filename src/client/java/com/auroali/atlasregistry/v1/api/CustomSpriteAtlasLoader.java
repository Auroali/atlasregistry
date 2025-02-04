package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.client.texture.atlas.AtlasLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public interface CustomSpriteAtlasLoader {
    CustomSpriteAtlasLoader DEFAULT = (manager, reference, prepareExecutor) -> SpriteLoader.fromAtlas(reference.getAtlas())
            .load(manager, reference.getId(), reference.getMipLevel(), prepareExecutor);
    CustomSpriteAtlasLoader NOOP = (manager, reference, prepareExecutor) -> CompletableFuture.completedFuture(
            new SpriteLoader.StitchResult(0, 0, 0, null, Collections.emptyMap(), CompletableFuture.completedFuture(null))
    );

    CompletableFuture<SpriteLoader.StitchResult> load(ResourceManager manager, SpriteAtlasReference reference, Executor prepareExecutor);
}

package com.auroali.atlasregistry.v1.api;

import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.resource.ResourceManager;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Interface to allow creating a custom sprite atlas loader
 *
 * @since 1.0.0
 */
public interface CustomSpriteAtlasLoader {
    /**
     * Calls vanilla's {@link SpriteLoader#fromAtlas} method
     *
     * @since 1.0.0
     */
    CustomSpriteAtlasLoader DEFAULT = (manager, reference, prepareExecutor) -> SpriteLoader.fromAtlas(reference.getAtlas())
            .load(manager, reference.getId(), reference.getMipLevel(), prepareExecutor);
    /**
     * Does nothing, leaving the atlas empty
     *
     * @since 1.0.0
     */
    CustomSpriteAtlasLoader NOOP = (manager, reference, prepareExecutor) -> CompletableFuture.completedFuture(
            new SpriteLoader.StitchResult(0, 0, 0, null, Collections.emptyMap(), CompletableFuture.completedFuture(null))
    );

    /**
     * Custom method to create a stitch result for an atlas
     *
     * @param manager         the resource manager
     * @param reference       the sprite atlas reference
     * @param prepareExecutor the prepare executor
     * @return a future for a StitchResult
     * @since 1.0.0
     */
    CompletableFuture<SpriteLoader.StitchResult> load(ResourceManager manager, SpriteAtlasReference reference, Executor prepareExecutor);
}

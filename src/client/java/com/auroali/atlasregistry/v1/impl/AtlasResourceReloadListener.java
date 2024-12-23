package com.auroali.atlasregistry.v1.impl;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AtlasResourceReloadListener implements IdentifiableResourceReloadListener, AutoCloseable {
    protected static final Identifier ID = new Identifier("altasregistry-v1", "reload_listener");
    public static final AtlasResourceReloadListener INSTANCE = new AtlasResourceReloadListener();

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    @Override
    public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
        List<CompletableFuture<Void>> atlasFutures = new ArrayList<>(AtlasRegistryImpl.ATLASES.size());
        for(Map.Entry<Identifier, SpriteAtlasReference> entry : AtlasRegistryImpl.ATLASES.entrySet()) {
            Identifier id = entry.getKey();
            SpriteAtlasReference reference = entry.getValue();
            CompletableFuture<Void> future = SpriteLoader.fromAtlas(reference.getAtlas())
                    .load(manager, id, reference.getMipLevel(), prepareExecutor)
                    .thenCompose(SpriteLoader.StitchResult::whenComplete)
                    .thenCompose(synchronizer::whenPrepared)
                    .thenAcceptAsync(stitchResult -> {
                        reference.getAtlas().upload(stitchResult);
                        reference.reload();
                    }, applyExecutor);
            atlasFutures.add(future);
        }
        return CompletableFuture.allOf(atlasFutures.toArray(new CompletableFuture[AtlasRegistryImpl.ATLASES.size()]));
    }

    @Override
    public void close() {
        for(SpriteAtlasReference reference : AtlasRegistryImpl.ATLASES.values()) {
            reference.getAtlas().close();
        }
    }
}

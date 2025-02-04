package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.SpriteAtlasReferenceBuilderImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.util.function.IntSupplier;

/**
 * Builds a new registerable SpriteAtlasReference. Once registered, the reference will have its atlas created
 * and populated once the game loads resources.
 * @see AtlasRegistry
 * @see VanillaAtlasReferences
 */
public interface SpriteAtlasReferenceBuilder {
    // Gets the mip level set in the options screen by the user
    IntSupplier USER_MIP_LEVEL = () -> MinecraftClient.getInstance().options.getMipmapLevels().getValue();

    /**
     * Creates a builder
     * @param id the id of the final atlas reference
     * @return the new builder
     */
    static SpriteAtlasReferenceBuilder create(Identifier id) {
        return new SpriteAtlasReferenceBuilderImpl(id);
    }

    /**
     * Sets the mip level of the final atlas reference
     * @param level the new mip level
     * @return this builder, for chaining
     */
    SpriteAtlasReferenceBuilder mipLevel(int level);

    /**
     * Sets the mip level of the final atlas reference
     * @param levelSupper the supplier for the mip level, can be used to dynamically change the mip level on reload
     * @return this builder, for chaining
     */
    SpriteAtlasReferenceBuilder mipLevel(IntSupplier levelSupper);

    /**
     * Sets the reload callback of the final atlas reference
     * @param callback the new reload callback
     * @return this builder, for chaining
     * @see AtlasReloadCallback
     */
    SpriteAtlasReferenceBuilder reloadCallback(AtlasReloadCallback callback);

    /**
     * Sets the loader to use for the final atlas reference
     * @param loader the custom sprite atlas loader
     * @return this builder, for chaining
     */
    SpriteAtlasReferenceBuilder loader(CustomSpriteAtlasLoader loader);

    /**
     * @return the final atlas reference
     */
    SpriteAtlasReference build();
}

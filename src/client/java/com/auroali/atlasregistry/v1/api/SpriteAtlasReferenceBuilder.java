package com.auroali.atlasregistry.v1.api;

import com.auroali.atlasregistry.v1.impl.SpriteAtlasReferenceBuilderImpl;
import net.minecraft.util.Identifier;

public interface SpriteAtlasReferenceBuilder {
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
     * Sets the reload callback of the final atlas reference
     * @param callback the new reload callback
     * @return this builder, for chaining
     */
    SpriteAtlasReferenceBuilder reloadCallback(AtlasReloadCallback callback);

    /**
     * @return the final atlas reference
     */
    SpriteAtlasReference build();
}

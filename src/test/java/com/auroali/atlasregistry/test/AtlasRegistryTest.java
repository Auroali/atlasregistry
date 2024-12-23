package com.auroali.atlasregistry.test;

import com.auroali.altasregistry.v1.api.AtlasRegistry;
import com.auroali.altasregistry.v1.api.SpriteAtlasReference;
import com.auroali.altasregistry.v1.api.SpriteAtlasReferenceBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

public class AtlasRegistryTest implements ClientModInitializer {
    public static final SpriteAtlasReference TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test"))
            .build();
    public static final SpriteAtlasReference OTHER_TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test2"))
            .mipLevel(3)
            .build();
    @Override
    public void onInitializeClient() {
        AtlasRegistry.register(TEST_ATLAS);
        AtlasRegistry.register(OTHER_TEST_ATLAS);
    }
}

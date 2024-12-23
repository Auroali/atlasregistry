package com.auroali.atlasregistry.test;

import com.auroali.altasregistry.v1.api.AtlasRegistry;
import com.auroali.altasregistry.v1.api.SpriteAtlasReference;
import com.auroali.altasregistry.v1.api.SpriteAtlasReferenceBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtlasRegistryTest implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("atlasregistry-test");
    public static final SpriteAtlasReference TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test"))
            .reloadCallback((identifier, atlas) -> LOGGER.info("Reloaded atlas {}", atlas))
            .build();
    public static final SpriteAtlasReference OTHER_TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test2"))
            .mipLevel(3)
            .reloadCallback((identifier, atlas) -> LOGGER.info("Reloaded atlas {}", atlas))
            .build();
    @Override
    public void onInitializeClient() {
        AtlasRegistry.register(TEST_ATLAS);
        AtlasRegistry.register(OTHER_TEST_ATLAS);
    }
}

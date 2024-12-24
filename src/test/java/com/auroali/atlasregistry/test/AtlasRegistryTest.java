package com.auroali.atlasregistry.test;

import com.auroali.atlasregistry.v1.api.AtlasRegistry;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.api.SpriteAtlasReferenceBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.util.Identifier;

public class AtlasRegistryTest implements ClientModInitializer {
    public static final SpriteAtlasReference TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test"))
            .build();
    public static final SpriteAtlasReference OTHER_TEST_ATLAS = SpriteAtlasReferenceBuilder.create(new Identifier("atlasregistry-test", "test2"))
            .mipLevel(3)
            .build();

    public static final KeyBinding OPEN_TEST_SCREEN = new KeyBinding(
            "key.atlasregistry-test.open_test_screen",
            InputUtil.Type.KEYSYM,
            InputUtil.GLFW_KEY_R,
            "category.atlasregistry-test.test_category"
    );

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(OPEN_TEST_SCREEN);
        AtlasRegistry.register(TEST_ATLAS);
        AtlasRegistry.register(OTHER_TEST_ATLAS);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while(OPEN_TEST_SCREEN.wasPressed())
                client.setScreen(new TestScreen(NarratorManager.EMPTY));
        });
    }
}

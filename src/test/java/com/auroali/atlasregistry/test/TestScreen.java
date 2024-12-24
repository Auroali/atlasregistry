package com.auroali.atlasregistry.test;

import com.auroali.atlasregistry.v1.api.VanillaAtlasReferences;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.texture.Sprite;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestScreen extends Screen {
    public static final Sprite ALTAS_TEST_SPRITE = AtlasRegistryTest.OTHER_TEST_ATLAS.getSprite(new Identifier("atlasregistry-test", "test2/test_texture2"));
    public static final Sprite COPPER_BLOCK_SPRITE = VanillaAtlasReferences.BLOCKS.getSprite(new Identifier("block/copper_block"));
    public static final Sprite DIAMOND_SPRITE = VanillaAtlasReferences.BLOCKS.getSprite(new Identifier("item/diamond"));

    protected TestScreen(Text title) {
        super(title);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawSprite(0, 0, 0, 32, 32, ALTAS_TEST_SPRITE);
        context.drawSprite(32, 0, 0, 16, 16, COPPER_BLOCK_SPRITE);
        context.drawSprite(48, 0, 0, 16, 16, DIAMOND_SPRITE);
    }
}

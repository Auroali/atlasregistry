package com.auroali.atlasregistry.test;

import com.auroali.atlasregistry.v1.api.SpriteAtlasReference;
import com.auroali.atlasregistry.v1.api.VanillaAtlasReferences;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestScreen extends Screen {
    // can't declare these as static final because they wouldnt update on resourcepack reload
    public Sprite atlasTest;
    public Sprite copperBlock;
    public Sprite diamond;

    protected TestScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        this.atlasTest = AtlasRegistryTest.OTHER_TEST_ATLAS.getSprite(new Identifier("atlasregistry-test", "test2/test_texture2"));
        this.copperBlock = VanillaAtlasReferences.BLOCKS.getSprite(new Identifier("block/copper_block"));
        this.diamond = VanillaAtlasReferences.BLOCKS.getSprite(new Identifier("item/diamond"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawSprite(0, 0, 0, 32, 32, this.atlasTest);
        context.drawSprite(32, 0, 0, 16, 16, this.copperBlock);
        context.drawSprite(48, 0, 0, 16, 16, this.diamond);
        SpriteAtlasReference otherAtlas = AtlasRegistryTest.OTHER_TEST_ATLAS;
        context.drawTexture(otherAtlas.getTexture(), 0, 32, 0, 0, otherAtlas.getWidth(), otherAtlas.getHeight(), otherAtlas.getWidth(), otherAtlas.getHeight());
        SpriteAtlasReference blocks = VanillaAtlasReferences.BLOCKS;
        context.drawTexture(blocks.getTexture(), otherAtlas.getWidth(), 32, 0, 0, blocks.getWidth(), blocks.getHeight(), blocks.getWidth(), blocks.getHeight());
    }
}

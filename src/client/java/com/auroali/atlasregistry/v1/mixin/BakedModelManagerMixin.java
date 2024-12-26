package com.auroali.atlasregistry.v1.mixin;

import com.auroali.atlasregistry.v1.impl.AtlasRegistryImpl;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BakedModelManager.class)
public class BakedModelManagerMixin {
    @Inject(method = "getAtlas", at = @At("HEAD"), cancellable = true)
    public void atlasregistry$injectCustomAtlases(Identifier id, CallbackInfoReturnable<SpriteAtlasTexture> cir) {
        if(AtlasRegistryImpl.ATLASES_BY_TEXTURE.containsKey(id))
            cir.setReturnValue(AtlasRegistryImpl.ATLASES_BY_TEXTURE.get(id).getAtlas());
    }
}

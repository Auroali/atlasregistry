package com.auroali.atlasregistry.v1.mixin;

import com.auroali.atlasregistry.v1.impl.AtlasRegistryImpl;
import com.auroali.atlasregistry.v1.impl.AtlasResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "close", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/BakedModelManager;close()V"))
    public void atlasregistry$closeTextures(CallbackInfo ci) {
        AtlasResourceReloadListener.INSTANCE.close();
    }

    @Inject(method = "getSpriteAtlas", at = @At("HEAD"), cancellable = true)
    public void atlasregistry$injectCustomAtlases(Identifier id, CallbackInfoReturnable<Function<Identifier, Sprite>> cir) {
        if(AtlasRegistryImpl.ATLASES_BY_TEXTURE.containsKey(id))
            cir.setReturnValue(AtlasRegistryImpl.ATLASES_BY_TEXTURE.get(id)::getSprite);
    }
}

package com.auroali.atlasregistry.v1.mixin;

import com.auroali.atlasregistry.v1.impl.AtlasResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "close", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/telemetry/TelemetryManager;close()V"))
    public void atlasregistry$closeTextures(CallbackInfo ci) {
        AtlasResourceReloadListener.INSTANCE.close();
    }
}

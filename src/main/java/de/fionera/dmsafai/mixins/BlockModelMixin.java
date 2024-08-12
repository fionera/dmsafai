package de.fionera.dmsafai.mixins;

import net.minecraft.client.renderer.block.model.BlockModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModel.class)
public abstract class BlockModelMixin {
    @Inject(
            method = {"isTextureReference"},
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private static void isTextureReferenceHead(String string, CallbackInfoReturnable<Boolean> cir) {
        if (string.isEmpty()) {
            cir.setReturnValue(false);
        }
    }
}

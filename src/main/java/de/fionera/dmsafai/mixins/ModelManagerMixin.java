package de.fionera.dmsafai.mixins;

import net.minecraft.client.resources.model.ModelManager;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelManager.class)
public abstract class ModelManagerMixin {
    @Redirect(
            method = {"method_45898"},
            at = @At(
                    value = "INVOKE",
                    target = "org/slf4j/Logger.error (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"
            )
    )
    private static void onError(Logger logger, String s, Object o1, Object o2) {
        logger.error(s + ": {}", ErrorReformatMixinBase.cleanArgs(o1, o2));
    }
}
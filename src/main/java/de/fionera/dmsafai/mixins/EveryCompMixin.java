package de.fionera.dmsafai.mixins;

import de.fionera.dmsafai.ErrorReformatMixinBase;
import net.mehvahdjukaar.every_compat.misc.ResourcesUtils;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ResourcesUtils.class)
public abstract class EveryCompMixin {
    @Redirect(
            method = {"lambda$addBlocksRecipes$9"},
            at = @At(
                    value = "INVOKE",
                    target = "org/apache/logging/log4j/Logger.error (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"
            )
    )
    private static void onError(Logger logger, String s, Object o1, Object o2) {
        logger.error(s + " {}", ErrorReformatMixinBase.cleanArgs(o1, o2));
    }
}

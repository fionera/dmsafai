package de.fionera.dmsafai.mixins;

import net.minecraft.world.item.crafting.RecipeManager;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {
    @Redirect(
            method = {"apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V"},
            at = @At(
                    value = "INVOKE",
                    target = "org/slf4j/Logger.error (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V"
            )
    )
    private void onError(Logger logger, String s, Object o1, Object o2) {
        logger.error(s + ": {}", ErrorReformatMixinBase.cleanArgs(o1, o2));
    }
}
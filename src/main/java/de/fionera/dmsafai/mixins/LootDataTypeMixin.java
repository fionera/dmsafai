package de.fionera.dmsafai.mixins;

import de.fionera.dmsafai.ErrorReformatMixinBase;
import net.minecraft.world.level.storage.loot.LootDataType;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LootDataType.class)
public abstract class LootDataTypeMixin {
    @Redirect(
            method = {"method_51205"},
            at = @At(
                    value = "INVOKE",
                    target = "org/slf4j/Logger.error (Ljava/lang/String;[Ljava/lang/Object;)V"
            )
    )
    private static void onError(Logger logger, String s, Object... o) {
        logger.error(s + ": {}", ErrorReformatMixinBase.cleanArgs(o));
    }
}

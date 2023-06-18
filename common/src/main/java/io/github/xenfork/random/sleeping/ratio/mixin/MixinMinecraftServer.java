package io.github.xenfork.random.sleeping.ratio.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import java.util.function.BooleanSupplier;

@Mixin(ServerLevel.class)
public abstract class MixinMinecraftServer {
    @Shadow @Final private MinecraftServer server;

    @Shadow public abstract ServerLevel getLevel();

    @Inject(method = "tick", at = @At("RETURN"))
    private void tick(BooleanSupplier booleanSupplier, CallbackInfo ci) {
        long dayTime = this.getLevel().getLevelData().getDayTime() % 24000;
        if (dayTime == 13000) {
            server
                    .getGameRules()
                    .getRule(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE)
                    .set(new Random().nextInt(1, 101), server);
        }
    }
}

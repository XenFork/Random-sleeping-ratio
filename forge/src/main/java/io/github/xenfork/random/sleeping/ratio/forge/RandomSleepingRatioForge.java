package io.github.xenfork.random.sleeping.ratio.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.xenfork.random.sleeping.ratio.RandomSleepingRatio;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RandomSleepingRatio.MOD_ID)
public class RandomSleepingRatioForge {
    public RandomSleepingRatioForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(RandomSleepingRatio.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
            RandomSleepingRatio.init();
    }
}
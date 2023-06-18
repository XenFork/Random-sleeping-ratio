package io.github.xenfork.random.sleeping.ratio.fabric;

import io.github.xenfork.random.sleeping.ratio.RandomSleepingRatio;
import net.fabricmc.api.ModInitializer;

public class RandomSleepingRatioFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        RandomSleepingRatio.init();
    }
}
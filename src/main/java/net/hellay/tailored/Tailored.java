package net.hellay.tailored;

import net.fabricmc.api.ModInitializer;
import net.hellay.tailored.init.TailoredItems;

public class Tailored implements ModInitializer {
    public static final String MODID = "tailored";

    @Override
    public void onInitialize() {
        TailoredItems.registerModItems();
    }
}

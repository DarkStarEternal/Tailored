package net.hellay.tailored.init;

import net.hellay.tailored.Tailored;
import net.hellay.tailored.item.scissors.BasicScissors;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TailoredItems {
    public static final Item SCISSORS = registerItem("scissors", new BasicScissors());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Tailored.MODID, name), item);
    }

    public static void registerModItems() {

    }
}


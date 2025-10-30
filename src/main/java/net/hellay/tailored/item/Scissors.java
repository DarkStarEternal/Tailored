package net.hellay.tailored.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;

public class Scissors extends SwordItem {
    public Scissors() {
        super(ToolMaterials.IRON, new Settings().rarity(Rarity.UNCOMMON));
    }
}

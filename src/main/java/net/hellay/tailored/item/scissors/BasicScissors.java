package net.hellay.tailored.item.scissors;

import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;

public class BasicScissors extends ScissorItem{
    public BasicScissors() {
        super(ToolMaterials.IRON, new Settings().rarity(Rarity.UNCOMMON).maxCount(1));
    }
}

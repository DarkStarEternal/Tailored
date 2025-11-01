package net.hellay.tailored.init;

import com.mojang.serialization.MapCodec;
import net.hellay.tailored.Tailored;
import net.hellay.tailored.enchantment.SharpshooterEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TailoredEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> SHARPSHOOTER = registerEntityEffect("sharpshooter", SharpshooterEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Tailored.MODID, name), codec);
    }

    public static void registerEnchantmentEffects() {

    }
}

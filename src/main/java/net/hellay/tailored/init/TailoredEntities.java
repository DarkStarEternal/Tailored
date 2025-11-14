package net.hellay.tailored.init;

import net.hellay.tailored.Tailored;
import net.hellay.tailored.entity.projectile.ScissorsProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TailoredEntities {
    public static final EntityType<ScissorsProjectileEntity> SCISSORS_PROJECTILE_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Tailored.MODID, "scissor"),
            EntityType.Builder.<ScissorsProjectileEntity>create(SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());


    public static void registerModEntities() {
    }
}

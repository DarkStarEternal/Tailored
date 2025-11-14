package net.hellay.tailored.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hellay.tailored.datagen.TailoredItemTagProvider;
import net.hellay.tailored.datagen.TailoredRegistryDataGenerator;
import net.hellay.tailored.init.TailoredEnchantments;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TailoredDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(TailoredRegistryDataGenerator::new);
        pack.addProvider(TailoredItemTagProvider::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, TailoredEnchantments::bootstrap);
    }
}

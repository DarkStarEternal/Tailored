package net.hellay.tailored.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hellay.tailored.entity.projectile.ScissorsProjectileModel;
import net.hellay.tailored.entity.projectile.ScissorsProjectileRenderer;
import net.hellay.tailored.init.TailoredEntities;

public class TailoredClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ScissorsProjectileModel.SCISSORS, ScissorsProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(TailoredEntities.SCISSORS_PROJECTILE_ENTITY, ScissorsProjectileRenderer::new);
    }
}

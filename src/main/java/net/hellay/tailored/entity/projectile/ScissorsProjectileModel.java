package net.hellay.tailored.entity.projectile;

import net.hellay.tailored.Tailored;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ScissorsProjectileModel extends EntityModel<ScissorsProjectileEntity> {

    public static final EntityModelLayer SCISSORS = new EntityModelLayer(Identifier.of(Tailored.MODID, "scissors"), "main");
    private final ModelPart scissors;


    public ScissorsProjectileModel(ModelPart root) {
        this.scissors = root.getChild("scissors");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("scissors",
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-8.0F, -8.0F, 0.0F, 16, 16, 0, new Dilation(0.0F)),
                ModelTransform.NONE
        );

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(ScissorsProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        scissors.render(matrices, vertices, light, overlay, color);
    }
}

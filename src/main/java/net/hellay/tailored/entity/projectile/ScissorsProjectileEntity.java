package net.hellay.tailored.entity.projectile;

import net.hellay.tailored.init.TailoredEntities;
import net.hellay.tailored.init.TailoredItems;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ScissorsProjectileEntity extends PersistentProjectileEntity {
    private float rotation;
    public Vector2f groundedOffset;

    private String scissorsName;
    private ItemStack itemStack;

    public ScissorsProjectileEntity(World world, PlayerEntity player) {
        super(TailoredEntities.SCISSORS_PROJECTILE_ENTITY, player, world, new ItemStack(TailoredItems.SCISSORS), null);
    }

    public void setScissorsName(String name) {
        this.scissorsName = name;
    }

    public String getScissorsName() {
        return this.scissorsName;
    }

    public void setItemStack(ItemStack stack) {
        this.itemStack = stack;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(TailoredItems.SCISSORS);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 4);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        if(result.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f,180f);
        }
        if(result.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f, 0f);
        }
        if(result.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f,-90f);
        }
        if(result.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f,90f);
        }

        if(result.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f(115f,180f);
        }
        if(result.getSide() == Direction.UP) {
            groundedOffset = new Vector2f(285f,180f);
        }
    }
}

package net.hellay.tailored.item.scissors;

import net.hellay.tailored.entity.projectile.ScissorsProjectileEntity;
import net.hellay.tailored.init.TailoredEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class ScissorItem extends SwordItem {
    public ScissorItem(ToolMaterials material, Settings settings) {
        super(material, settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        RegistryKey<Enchantment> key = TailoredEnchantments.SHARPSHOOTER;

        RegistryWrapper<Enchantment> enchantmentWrapper = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getReadOnlyWrapper();
        RegistryEntry<Enchantment> entry = enchantmentWrapper.getOrThrow(key);


        if (EnchantmentHelper.getLevel(entry, itemStack) > 0) {
            world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_CHAIN_PLACE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            if (!world.isClient) {
                ScissorsProjectileEntity scissorsProjectileEntity = new ScissorsProjectileEntity(world, user);
                scissorsProjectileEntity.setScissorsName(this.getCreatorNamespace(itemStack));
                scissorsProjectileEntity.setItemStack(itemStack);
                scissorsProjectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0.0F);
                world.spawnEntity(scissorsProjectileEntity);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            itemStack.decrementUnlessCreative(1, user);
            return TypedActionResult.success(itemStack, world.isClient());
        }

        return TypedActionResult.fail(itemStack);
    }

    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        SnowballEntity snowballEntity = new SnowballEntity(world, pos.getX(), pos.getY(), pos.getZ());
        snowballEntity.setItem(stack);
        return snowballEntity;
    }
}

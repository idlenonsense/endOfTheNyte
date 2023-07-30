package org.endOfTheNyte.block;

import org.endOfTheNyte.effect.ModEffects;
import org.endOfTheNyte.sound.ModSounds;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EndenyteBlock extends Block {

    public EndenyteBlock(FabricBlockSettings settings) {
        super(settings);
    }

    private void enableFlight(PlayerEntity player, World world, BlockPos pos) {
        if (!player.isSpectator()) {
            player.addStatusEffect(new StatusEffectInstance(ModEffects.DRAGONS_BLESSING, 500, 0));
            world.playSound(null, pos, ModSounds.ENDENYTE_BLOCK_ACTIVATED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(ModSounds.ENDENYTE_BLOCK_FALL, 1.0f, 1.0f);
        if (entity.handleFallDamage(fallDistance, 0.2f, world.getDamageSources().fall())) {
            entity.playSound(ModSounds.ENDENYTE_BLOCK_FALL, 0.70f, 0.45f);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }
        enableFlight(player, world, pos);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        disableFlight(player, world, pos);
    }

    private void disableFlight(PlayerEntity entity, World world, BlockPos pos) {
        if (entity.hasStatusEffect(ModEffects.DRAGONS_BLESSING)) {
            world.playSound(null, pos, ModSounds.ENDENYTE_BLOCK_DEACTIVATED, SoundCategory.BLOCKS, 1.0f, 1.0f);
            entity.removeStatusEffect(ModEffects.DRAGONS_BLESSING);
        }
    }
}
package io.github.FMG9167.passivearmor;


import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class AnvilEventHandler {
    public static void register() {
        UseBlockCallback.EVENT.register(AnvilEventHandler::onAnvilUse);
    }

    private static ActionResult onAnvilUse(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        BlockState state = world.getBlockState(hitResult.getBlockPos());
        if (state.getBlock() instanceof AnvilBlock){
        }

        return ActionResult.PASS;
    }
}

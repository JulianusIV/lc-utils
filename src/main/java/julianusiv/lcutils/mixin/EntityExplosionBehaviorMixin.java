package julianusiv.lcutils.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import julianusiv.lcutils.LcUtils;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.explosion.EntityExplosionBehavior;
import net.minecraft.world.explosion.Explosion;

@Mixin(EntityExplosionBehavior.class)
public abstract class EntityExplosionBehaviorMixin {

    //(Lnet.minecraft.world.explosion.Explosion;Lnet.minecraft.world.BlockView;Lnet.minecraft.util.math.BlockPos;Lnet.minecraft.block.BlockState;F)Z;
    @Inject(at = @At("HEAD"), cancellable = true, method = "canDestroyBlock")
    private void cancelWorldspawnExplosion(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float power, CallbackInfoReturnable<Boolean> info) {
        if (LcUtils.isSpawnArea(explosion.getEntity().getWorld().getSpawnPos(), pos))
            info.setReturnValue(false);
    }
}
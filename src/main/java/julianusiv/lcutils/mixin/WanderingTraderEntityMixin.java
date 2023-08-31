package julianusiv.lcutils.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;

@Mixin(WanderingTraderEntity.class)
public class WanderingTraderEntityMixin extends MerchantEntity {

    @Shadow
    @Override
    public native void afterUsing(TradeOffer offer);

    @Shadow
    @Override
    public native void fillRecipes();

    @Shadow
    @Override
    public native PassiveEntity createChild(ServerWorld arg0, PassiveEntity arg1);
    
    public WanderingTraderEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }
}

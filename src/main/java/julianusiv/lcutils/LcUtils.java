package julianusiv.lcutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import julianusiv.lcutils.config.SimpleConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class LcUtils implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lc-utils");
	public static final SimpleConfig CONFIG = SimpleConfig.of("lc-utils").provider((filename) -> {
		//default config
		return """
				spawnprotection=10
				""";
	}).request();

	@Override
	public void onInitialize() {
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
			if (entity instanceof ServerPlayerEntity player) {
				StringBuilder builder = new StringBuilder("You died at X: ");
				builder.append(player.getBlockX());
				builder.append(" Y: ");
				builder.append(player.getBlockY());
				builder.append(" Z: ");
				builder.append(player.getBlockZ());

				player.sendMessage(Text.of(builder.toString()));
			}
		});

		UseBlockCallback.EVENT.register((player, world, hand, result) -> {
			if (isSpawnArea(world.getSpawnPos(), result.getBlockPos()) && !player.isCreative())
				return ActionResult.FAIL;
			return ActionResult.PASS;
		});

		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, entity) -> {
			if (isSpawnArea(world.getSpawnPos(), pos) && !player.isCreative())
				return false;
			return true;
		});
	}

	public static boolean isSpawnArea(BlockPos spawnPos, BlockPos block) {
		double diffX = (double)spawnPos.getX() - block.getX();
		double diffZ = (double)spawnPos.getZ() - block.getZ();

		return Math.sqrt((diffX * diffX) + (diffZ * diffZ)) < CONFIG.getOrDefault("spawnprotection", 10) + 1;
	}
}
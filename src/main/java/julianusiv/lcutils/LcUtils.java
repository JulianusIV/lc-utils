package julianusiv.lcutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class LcUtils implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("lc-utils");

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
	}
}
package julianusiv.lcutils.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import com.google.common.collect.ImmutableMap;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import julianusiv.lcutils.Factory.ItemFactory;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

@Mixin(TradeOffers.class)
public abstract class TradeOffersMixin {
	@Final
	@Mutable
	@Shadow
	public static final Int2ObjectMap<TradeOffers.Factory[]> WANDERING_TRADER_TRADES;

	@Shadow
	private native static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap);

	static {
		WANDERING_TRADER_TRADES = copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{
                  new ItemFactory(Items.POTATO, 1, 4, 32, 1),
                  new ItemFactory(Items.BAKED_POTATO, 64, 1, 128, 1),
                  new ItemFactory(Items.FIREWORK_ROCKET, 3, 1, 128,1),
                  new ItemFactory(Items.ACACIA_SAPLING, 5, 1, 16,1),
                  new ItemFactory(Items.DARK_OAK_SAPLING, 5, 1, 16,1),
                  new ItemFactory(Items.JUNGLE_SAPLING, 5, 1, 16, 1),
                  new ItemFactory(Items.MANGROVE_PROPAGULE, 10, 1, 16, 1),
                  new ItemFactory(Items.SMALL_DRIPLEAF, 1, 2, 12, 1),
                  new ItemFactory(Items.PUMPKIN_SEEDS, 1, 1, 16,1),
                  new ItemFactory(Items.MELON_SEEDS, 1, 1, 16,1),
                  new ItemFactory(Items.SLIME_BALL, 2, 1, 25,1),
                  new ItemFactory(Items.GLOWSTONE, 2, 1, 25, 1),
                  new ItemFactory(Items.HONEY_BOTTLE, 3, 1, 25,1),
                  new ItemFactory(Items.HAY_BLOCK, 2, 1, 64,1),
                  new ItemFactory(Items.ZOMBIE_HEAD, 8, 1, 1,1),
                  new ItemFactory(Items.CREEPER_HEAD, 8, 1, 1,1),
                  new ItemFactory(Items.SKELETON_SKULL, 8, 1, 1,1),
                  new ItemFactory(Items.BONE_BLOCK, 2, 1, 20,1),
                  new ItemFactory(Items.ENDER_PEARL, 6, 1, 16,1),
                  new ItemFactory(Items.GUNPOWDER, 1, 1, 32,1),
                  new ItemFactory(Items.NAUTILUS_SHELL, 5, 1, 10,1),
                  new ItemFactory(Items.SEA_PICKLE, 2, 1, 12,1),
                  new ItemFactory(Items.MOSS_BLOCK, 1, 2, 32, 1),
                  new ItemFactory(Items.PODZOL, 3, 1, 32,1),
                  new ItemFactory(Items.CACTUS, 1, 1, 32,1),
                  new ItemFactory(Items.PACKED_ICE, 3, 1, 40,1),
                  new ItemFactory(Items.BLUE_ICE, 18, 1, 20,1),
                  new ItemFactory(Items.PUFFERFISH_BUCKET, 4, 1, 8,1),
                  new ItemFactory(Items.TROPICAL_FISH_BUCKET, 4, 1, 8,1),
                  new ItemFactory(Items.SWEET_BERRIES, 2, 1, 16,1),
                  new ItemFactory(Items.BAMBOO, 2, 1, 32,1),
                  new ItemFactory(Items.SUGAR_CANE, 1, 2, 32, 1),
                  new ItemFactory(Items.TERRACOTTA, 1, 1, 64,1),
                  new ItemFactory(Items.PRISMARINE_SHARD, 4, 1, 28,1)
		}, 2, new TradeOffers.Factory[] {
                  new ItemFactory(Items.TOTEM_OF_UNDYING,  56, 1, 1,1),
                  new ItemFactory(Items.WITHER_SKELETON_SKULL, 64, 1, 1,1),
                  new ItemFactory(Items.TRIDENT, 64, 1, 1,1),
                  new ItemFactory(Items.GHAST_TEAR, 12, 1, 4,1),
                  new ItemFactory(Items.DRAGON_BREATH, 32, 1, 4,1),
                  new ItemFactory(Items.HEART_OF_THE_SEA, 64, 1, 2,1),
                  new ItemFactory(Items.ENDER_EYE, 16, 1, 3,1),
                  new ItemFactory(Items.DIAMOND_HELMET, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_CHESTPLATE, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_LEGGINGS, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_BOOTS, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_PICKAXE, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_SWORD, 20, 1, 2,1),
                  new ItemFactory(Items.DIAMOND_AXE, 20, 1, 2,1),
                  new ItemFactory(Items.NETHER_STAR, 64, 1, 1, 1)
		}));
	}
}
package julianusiv.lcutils.Factory;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

public class ItemFactory implements TradeOffers.Factory {
    private final ItemStack sell;
    private final int price;
    private final int count;
    private final int maxUses;
    private final int experience;
    private final float multiplier;

    public ItemFactory(Block block, int price, int count, int maxUses, int experience) {
        this(new ItemStack(block), price, count, maxUses, experience);
    }

    public ItemFactory(Item item, int price, int count, int experience) {
        this(new ItemStack(item), price, count, 12, experience);
    }

    public ItemFactory(Item item, int price, int count, int maxUses, int experience) {
        this(new ItemStack(item), price, count, maxUses, experience);
    }

    public ItemFactory(ItemStack itemStack, int price, int count, int maxUses, int experience) {
        this(itemStack, price, count, maxUses, experience, 0.05F);
    }

    public ItemFactory(ItemStack itemStack, int price, int count, int maxUses, int experience, float multiplier) {
        this.sell = itemStack;
        this.price = price;
        this.count = count;
        this.maxUses = maxUses;
        this.experience = experience;
        this.multiplier = multiplier;
    }

    @Override
    public TradeOffer create(Entity arg0, Random arg1) {
        return new TradeOffer(
            new ItemStack(Items.EMERALD, this.price),
            new ItemStack(this.sell.getItem(), this.count),
            this.maxUses,
            this.experience,
            this.multiplier);
    }

}

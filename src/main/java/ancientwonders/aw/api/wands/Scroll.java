package ancientwonders.aw.api.wands;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Scroll extends Item {
    public static boolean isScroll(Item item){
        return item instanceof Scroll;
    }

    public static boolean isScroll(ItemStack item){
        return isScroll(item.getItem());
    }

    private boolean event;

    public Scroll(Item.Properties properties, boolean event){
        super(properties);
        this.event = event;
    }

    public boolean getEvent(){
        return event;
    }
}

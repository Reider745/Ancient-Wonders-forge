package reider745.aw.api.wands;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

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

    public void install(TileEntity tile, ItemStack item, PlayerEntity player){
        item.setCount(item.getCount()-1);
    }
}

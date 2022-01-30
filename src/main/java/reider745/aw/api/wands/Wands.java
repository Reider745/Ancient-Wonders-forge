package reider745.aw.api.wands;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class Wands extends Item {

    public static boolean isWand(Item item){
        return item instanceof Wands;
    }

    public static boolean isWand(ItemStack item){
        return isWand(item.getItem());
    }

    public Wands(Item.Properties properties){
        super(properties);
    }

    public ArrayList<ItemStack> getScrolls(ItemStack item){
        return getScrolls(item.getTag());
    }

    public static ArrayList<ItemStack> getScrolls(CompoundNBT tag){
        ArrayList<ItemStack> scrolls = new ArrayList<ItemStack>();
        if(tag == null)
            return scrolls;
        if(!tag.contains("size"))
            return scrolls;
        int size = tag.getInt("size");
        for(int i = 0;i < size;i++) {
            LogManager.getLogger().error(tag.getString("mod_" + i));
            LogManager.getLogger().error(tag.getString("id_" + i));
            ItemStack scroll = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("mod_" + i), tag.getString("id_" + i))), 1);
            scrolls.add(scroll);
        }
        return scrolls;
    }
    public static CompoundNBT putScrolls(CompoundNBT tag, ArrayList<ItemStack> scrolls){
        int size = scrolls.size();
        if(tag == null)
            tag = new CompoundNBT();
        tag.putInt("size", size);
        for(int i = 0;i < size;i++){
            ItemStack scroll = scrolls.get(i);
            tag.putString("mod_"+i, scroll.getItem().getRegistryName().getNamespace());
            tag.putString("id_"+i, scroll.getItem().getRegistryName().getPath());
        }
        return tag;
    }
    public static void putScrolls(ItemStack item, ArrayList<ItemStack> scrolls){
        CompoundNBT tag = putScrolls(item.getTag(), scrolls);
        item.setTag(tag);
    }

    @Override
    public ITextComponent getDisplayName(ItemStack itemStack) {
        ArrayList<ItemStack> scrolls = getScrolls(itemStack);
        String name = super.getDisplayName(itemStack).getString();
        for(int i = 0;i < scrolls.size();i++)
            name+="\n"+scrolls.get(i).getDisplayName().getString();
        return ITextComponent.getTextComponentOrEmpty(name);
    }
}

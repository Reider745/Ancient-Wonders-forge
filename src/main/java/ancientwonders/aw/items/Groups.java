package ancientwonders.aw.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

public class Groups {
    public static ItemGroup aw_items = (new net.minecraft.item.ItemGroup("aw"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CustomItems.magic_wand.get());
        }
    });
}
package ancientwonders.aw.api.base;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface IClickedTileEntity {
    boolean click(PlayerEntity player, ItemStack item);
}

package reider745.aw.api.base;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeTileEntity;

public class BaseTile extends TileEntity implements IClickedTileEntity, ITickableTileEntity, IForgeTileEntity {

    public BaseTile(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public void tick() {}

    public boolean click(PlayerEntity player, ItemStack item) {
        return false;
    }
}

package reider745.aw.block.MagicReconnector;

import reider745.aw.api.base.BaseTile;
import reider745.aw.api.wands.Scroll;
import reider745.aw.api.wands.Wands;
import reider745.aw.block.CustomBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;

public class TileMagicReconnector extends BaseTile {
    private ItemStack wand;
    private ArrayList<ItemStack> scrolls;

    public TileMagicReconnector(){
        super(CustomBlocks.Tiles.magic_reconnector);
        scrolls = new ArrayList<ItemStack>();
    }

    public ItemStack getWand(){
        return wand;
    }

    public void updateModel(){
        BlockState state = getBlockState();
        BlockPos coords = new BlockPos(pos.getX(), pos.getY()+1, pos.getZ());
        world.notifyBlockUpdate(coords, state, state, Constants.BlockFlags.DEFAULT);
    }

    @Override
    public void onLoad() {
        updateModel();
    }

    @Override
    public void read(BlockState state, CompoundNBT tag) {
        scrolls = Wands.getScrolls(tag);
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        Wands.putScrolls(tag, scrolls);
        return super.write(tag);
    }

    @Override
    public boolean click(PlayerEntity player, ItemStack item) {
        if(item.isEmpty())
            return false;
        if(Wands.isWand(item)){
            wand = item.copy();
            item.setCount(item.getCount()-1);
            updateModel();
            return true;
        }else if(Scroll.isScroll(item) && wand != null){
            scrolls.add(item);
            Wands.putScrolls(wand, scrolls);
            ((Scroll) item.getItem()).install(this, item, player);
            return true;
        }else if(wand != null){
            ItemEntity ent = new ItemEntity(world, pos.getX()+.5, pos.getY()+1.5, pos.getZ()+.5);
            ent.setItem(wand);
            world.addEntity(ent);
            wand = null;
            updateModel();
        }
        return false;
    }
}

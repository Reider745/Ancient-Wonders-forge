package ancientwonders.aw.block.MagicReconnector;

import ancientwonders.aw.api.base.BaseBlock;
import ancientwonders.aw.block.CustomBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import javax.annotation.Nullable;
public class MagicReconnector extends BaseBlock {
    public MagicReconnector(){
        super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD));
    }

    @Override
    public void setupClient(){
        ClientRegistry.bindTileEntityRenderer(CustomBlocks.Tiles.magic_reconnector, RenderMagicReconnector::new);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileMagicReconnector();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}

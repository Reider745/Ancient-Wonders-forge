package ancientwonders.aw.api.base;

import ancientwonders.aw.block.CustomBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseBlock extends Block {
    public static List<BaseBlock> BLOCKS = new ArrayList<BaseBlock>();

    public BaseBlock(Properties properties) {
        super(properties);
        BLOCKS.add(this);
    }

    @SubscribeEvent
    public static void setupClients(FMLClientSetupEvent event){
        for(int i = 0;i < BLOCKS.size();i++)
            BLOCKS.get(i).setupClient();
    }


    public void setupClient(){ }
}

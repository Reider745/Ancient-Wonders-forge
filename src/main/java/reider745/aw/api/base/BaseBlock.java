package reider745.aw.api.base;

import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

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

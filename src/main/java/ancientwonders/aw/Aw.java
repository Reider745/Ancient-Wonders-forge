package ancientwonders.aw;

import ancientwonders.aw.api.ClassType;
import ancientwonders.aw.api.base.IClickedTileEntity;
import ancientwonders.aw.api.MagicCore;
import ancientwonders.aw.block.CustomBlocks;
import ancientwonders.aw.items.CustomItems;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("aw")
public class Aw {
    final public static String modid = "aw";
    public Aw() {

        MagicCore.registerClass(new ClassType("mage")
                .addParameter("magic", 5, 100)
                .addParameter("protection", 0, 40)
                .addParameter("necromancer", 0, 10)
                .addParameter("aspects", 0, 100000)
                .setParamerter("aspectsNow", 5000));

        MagicCore.registerClass(new ClassType("warrior")
                .addParameter("magic", 5, 15)
                .addParameter("protection", 10, 100)
                .addParameter("necromancer", 0, 5)
                .addParameter("aspects", 0, 10000)
                .setParamerter("aspectsNow", 100));

        MagicCore.registerClass(new ClassType("necromancer")
                .addParameter("magic", 5, 50)
                .addParameter("protection", 0, 30)
                .addParameter("necromancer", 5, 100)
                .addParameter("aspects", 0, 50000)
                .setParamerter("aspectsNow", 2000));

        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        CustomBlocks.BLOCKS.register(event);
        CustomItems.ITEMS.register(event);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickBlock event){
        TileEntity tile = event.getWorld().getTileEntity(event.getPos());
        if(tile instanceof IClickedTileEntity){
            event.setCanceled(((IClickedTileEntity) tile).click(event.getPlayer(), event.getItemStack()));
        }
    }
}

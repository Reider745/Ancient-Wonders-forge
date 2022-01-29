package ancientwonders.aw.block;

import ancientwonders.aw.Aw;
import ancientwonders.aw.block.MagicReconnector.MagicReconnector;
import ancientwonders.aw.block.MagicReconnector.TileMagicReconnector;
import ancientwonders.aw.items.CustomItems;
import ancientwonders.aw.items.Groups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CustomBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Aw.modid);

    public static final RegistryObject<Block> magic_reconnector = BLOCKS.register("magic_reconnector", MagicReconnector::new);

    @SubscribeEvent
    public static void registerTile(final RegistryEvent.Register<TileEntityType<?>> event){
        event.getRegistry().register(TileEntityType.Builder.create(TileMagicReconnector::new, magic_reconnector.get()).build(null).setRegistryName(Aw.modid, "magic_reconnector"));
    }
    public static class Tiles {
        @ObjectHolder(Aw.modid + ":magic_reconnector")
        public static TileEntityType<TileMagicReconnector> magic_reconnector;
    }

    //items
    public static RegistryObject<Item> magic_reconnector_item = CustomItems.ITEMS.register("magic_reconnector", () -> new BlockItem(magic_reconnector.get(), new Item.Properties().group(Groups.aw_items)));
}

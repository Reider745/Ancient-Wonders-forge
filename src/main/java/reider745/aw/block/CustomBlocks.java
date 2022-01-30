package reider745.aw.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import reider745.aw.Aw;
import reider745.aw.api.base.BaseBlock;
import reider745.aw.block.MagicReconnector.MagicReconnector;
import reider745.aw.block.MagicReconnector.TileMagicReconnector;
import reider745.aw.items.CustomItems;
import reider745.aw.items.Groups;
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

    public static final RegistryObject<Block> magic_reenactor = BLOCKS.register("magic_reenactor", MagicReconnector::new);
    public static final RegistryObject<Block> test = BLOCKS.register("test", () -> new BaseBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD)));

    @SubscribeEvent
    public static void registerTile(final RegistryEvent.Register<TileEntityType<?>> event){
        event.getRegistry().register(TileEntityType.Builder.create(TileMagicReconnector::new, magic_reenactor.get()).build(null).setRegistryName(Aw.modid, "magic_reenactor"));
    }
    public static class Tiles {
        @ObjectHolder(Aw.modid + ":magic_reenactor")
        public static TileEntityType<TileMagicReconnector> magic_reconnector;
    }

    //items
    public static RegistryObject<Item> magic_reenactor_item = CustomItems.ITEMS.register("magic_reenactor", () -> new BlockItem(magic_reenactor.get(), new Item.Properties().group(Groups.aw_items)));
    public static RegistryObject<Item> test_item = CustomItems.ITEMS.register("test", () -> new BlockItem(test.get(), new Item.Properties().group(Groups.aw_items)));
}

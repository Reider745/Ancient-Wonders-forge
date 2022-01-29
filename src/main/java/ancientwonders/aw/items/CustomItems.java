package ancientwonders.aw.items;

import ancientwonders.aw.Aw;
import ancientwonders.aw.api.wands.Scroll;
import ancientwonders.aw.api.wands.Wands;
import ancientwonders.aw.items.material.Piece;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CustomItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Aw.modid);

    public static final RegistryObject<Item> piece_magic = ITEMS.register("piece_magic", Piece.createDefault("magic", 1, Groups.aw_items, false));
    public static final RegistryObject<Item> piece_protection = ITEMS.register("piece_protection", Piece.createDefault("protection", 1, Groups.aw_items, false));
    public static final RegistryObject<Item> piece_necromancer = ITEMS.register("piece_necromancer", Piece.createDefault("necromancer", 1, Groups.aw_items, false));

    public static final RegistryObject<Item> piece_mage = ITEMS.register("piece_class_mage", Piece.createDefault("mage", 1, Groups.aw_items, true));
    public static final RegistryObject<Item> piece_warrior = ITEMS.register("piece_class_warrior", Piece.createDefault("warrior", 1, Groups.aw_items, true));
    public static final RegistryObject<Item> piece_necromancer_class = ITEMS.register("piece_class_necromancer", Piece.createDefault("necromancer", 1, Groups.aw_items, true));

    public static final RegistryObject<Item> magic_wand = ITEMS.register("magic_wand", () -> new Wands(new Item.Properties().group(Groups.aw_items).maxStackSize(1)));

    public static final RegistryObject<Item> event_use_block = ITEMS.register("event_use_block", () -> new Scroll(new Item.Properties().group(Groups.aw_items).maxStackSize(1), true));

    public static final RegistryObject<Item> destroy_block = ITEMS.register("destroy_block", () -> new Scroll(new Item.Properties().group(Groups.aw_items).maxStackSize(1), false));
}

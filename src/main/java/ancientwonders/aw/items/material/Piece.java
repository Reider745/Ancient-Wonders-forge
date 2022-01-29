package ancientwonders.aw.items.material;

import ancientwonders.aw.api.MagicCore;
import ancientwonders.aw.api.Translation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class Piece extends Item {
    public static Supplier<Item> createDefault(String name, int value, ItemGroup group, boolean player_class){
        return () -> new Piece(name, value, group, player_class);
    }

    String name;
    int value;
    boolean player_class;
    protected Piece(String name, int value, ItemGroup group, boolean player_class){
        super(new Item.Properties().group(group));
        this.name = name;
        this.value = value;
        this.player_class = player_class;
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 4;
    }

    @Override
    public boolean hasEffect(ItemStack p_77636_1_) {
        return player_class;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World region, PlayerEntity player, Hand hand) {
        if(hand == Hand.MAIN_HAND){
            if(player_class){
                if(!MagicCore.isPlayer(player)){
                    MagicCore.setPlayer(player, name);
                    player.sendMessage(Translation.getTextComp("aw.message.add_class", new Translation.TextReplaceString[] {new Translation.TextReplaceString("name", name)}), player.getUniqueID());
                }else
                    player.sendMessage(Translation.getTextComp("aw.message.yes_class"), player.getUniqueID());
            }else
                MagicCore.piece(player, name, value);
        }
        return super.onItemRightClick(region, player, hand);
    }

    /*@Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if(player_class){
            PlayerEntity player = context.getPlayer();
            if(!MagicCore.isPlayer(player)){
                MagicCore.setPlayer(player, name);
                player.sendMessage(Translation.getTextComp("aw.message.add_class", new Translation.TextReplaceString[] {new Translation.TextReplaceString("name", name)}), player.getUniqueID());
            }else
                player.sendMessage(Translation.getTextComp("aw.message.yes_class"), player.getUniqueID());
        }else
            MagicCore.piece(context.getPlayer(), name, value);
        return ActionResultType.PASS;
    }*/
}

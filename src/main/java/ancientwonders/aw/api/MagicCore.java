package ancientwonders.aw.api;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagicCore {
    private static class ClassPlayer {
        private HashMap<String, Integer> parameters;
        private ClassPlayer(ClassType type){
            parameters = (HashMap<String, Integer>) type.getParameters().clone();
        }

        public void set(String name, int value){
            parameters.put(name, value);
        }

        public int get(String name){
            return parameters.get(name).intValue();
        }

        public void add(String name, int value){
            set(name, get(name) + value);
        }
    }
    private static HashMap<String, ClassType> types = new HashMap<String, ClassType>();
    private static HashMap<PlayerEntity, ClassPlayer> players = new HashMap<PlayerEntity, ClassPlayer>();

    public static void registerClass(ClassType type){
        types.put(type.name, type);
    }
    public static ClassType getClassType(String name){
        if(types.containsKey(name))
            return types.get(name);
        return null;
    }

    public static boolean isPlayer(PlayerEntity player){
        return players.containsKey(player);
    }

    public static void setPlayer(PlayerEntity player, String name){
        players.put(player, new ClassPlayer(getClassType(name)));
    }

    public static ClassPlayer getPlayer(PlayerEntity player){
        return players.get(player);
    }
    public static void setPlayer(PlayerEntity player, ClassPlayer cl){
        players.put(player, cl);
    }

    public static void piece(PlayerEntity player, String name, int value){
        if(isPlayer(player)){
            ClassPlayer class_player = getPlayer(player);
            int now = class_player.get(name);
            int max = class_player.get(name+"Max");
            if(now < max)
                if(now + value <= max){
                    class_player.set(name, now+value);
                    player.sendMessage(Translation.getTextComp("aw.message.update_parameter", new Translation.TextReplace[] {new Translation.TextReplaceString("name", name), new Translation.TextReplace("value", value), new Translation.TextReplace("now", class_player.get(name))}), player.getUniqueID());
                }else{
                    class_player.set(name, max);
                    player.sendMessage(Translation.getTextComp("aw.message.update_parameter", new Translation.TextReplace[] {new Translation.TextReplaceString("name", name), new Translation.TextReplace("value", value), new Translation.TextReplace("now", class_player.get(name))}), player.getUniqueID());
                }
            else
                player.sendMessage(Translation.getTextComp("aw.message.max_level_parameter", new Translation.TextReplaceString[] {new Translation.TextReplaceString("name", name)}), player.getUniqueID());
            setPlayer(player, class_player);
        }else{
            player.sendMessage(Translation.getTextComp("aw.message.noy_class"), player.getUniqueID());
        }
    }
}

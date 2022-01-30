package reider745.aw.api;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class Translation {
    public static class TextReplace {
        public TextReplace(String name, int value){
            this.name = name;
            this.value = value;
        }
        protected String name;
        protected int value;
        protected String get(String str){
            return str.replace("{"+name+"}", ""+value);
        }
    }
    public static class TextReplaceString extends TextReplace {
        public TextReplaceString(String name, String value_str){
            super(name, 0);
            this.value_str = value_str;
        }
        private String value_str;

        @Override
        protected String get(String str) {
            return str.replace("{"+name+"}", value_str);
        }
    }
    public static String getText(String key){
        return new TranslationTextComponent(key).getString();
    }
    public static String getText(String key, TextReplace[] replaces){
        String str = getText(key);
        for (int i = 0; i < replaces.length; i++)
            str = replaces[i].get(str);
        return str;
    }
    public static ITextComponent getTextComp(String key){
        return ITextComponent.getTextComponentOrEmpty((getText(key)));
    }
    public static ITextComponent getTextComp(String key, TextReplace[] replaces){
        return ITextComponent.getTextComponentOrEmpty((getText(key, replaces)));
    }
}

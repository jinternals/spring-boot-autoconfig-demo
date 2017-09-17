package com.jinternals.translator.component;


import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;

import static com.google.cloud.translate.Translate.TranslateOption.sourceLanguage;
import static com.google.cloud.translate.Translate.TranslateOption.targetLanguage;

public class Translator {

    Translate translate;


    public Translator(Translate translate){
        this.translate = translate;
    }


    public String translate(String text,String from, String to){

        Translation translation =
                translate.translate(
                        text,
                        sourceLanguage(from),
                        targetLanguage(to));
        return translation.getTranslatedText();
    }

    public Translate getTranslate() {
        return translate;
    }
}

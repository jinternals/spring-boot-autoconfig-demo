package com.jinternals.translator.component;


import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;

import static com.google.cloud.translate.Translate.TranslateOption.sourceLanguage;
import static com.google.cloud.translate.Translate.TranslateOption.targetLanguage;

public class Translator {

    private String from;
    private String to;
    Translate translate;


    public Translator(Translate translate,String from, String to){
        this.from = from;
        this.to = to;
        this.translate = translate;
    }


    public String translate(String text){

        Translation translation =
                translate.translate(
                        text,
                        sourceLanguage(from),
                        targetLanguage(to));
        return translation.getTranslatedText();
    }


    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Translate getTranslate() {
        return translate;
    }
}

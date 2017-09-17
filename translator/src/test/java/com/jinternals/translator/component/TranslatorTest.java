package com.jinternals.translator.component;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.cloud.translate.Translate.TranslateOption.sourceLanguage;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TranslatorTest {

    private Translator translator;
    private String HOLA = "hola";
    private String FROM = "en";
    private String TO = "es";

    @Mock
    private Translate translate;

    @Mock
    private Translation translation;

    @Before
    public void setup() {
        translator = new Translator(translate);
    }

    @Test
    public void shouldTranslate() {
        Mockito.when(translate.translate(any(String.class), any(),any())).thenReturn(translation);
        Mockito.when(translation.getTranslatedText()).thenReturn(HOLA);
        String hola = translator.translate("Hello",FROM,TO);
        assertEquals(HOLA,hola);
    }

}
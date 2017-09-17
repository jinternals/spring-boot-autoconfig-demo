package com.jinternals.autoconfig.example.controllers;

import com.jinternals.autoconfig.example.dto.TranslatorRequest;
import com.jinternals.translator.component.Translator;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.jinternals.autoconfig.example.controllers.TranslatorTestHelper.toJson;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TranslatorController.class)
public class TranslatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Translator translator;

    @Test
    public void shouldTranslateTextFromEnglishToSpanish() throws Exception {
        TranslatorRequest translatorDTO = new TranslatorRequest("hello","en","es");


        Mockito.when(translator.translate(translatorDTO.getText(),translatorDTO.getFrom(),translatorDTO.getTo())).thenReturn("hola");

        mvc.perform(post("/api/translator")
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(translatorDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text", is("hola")))
                .andDo(print());

    }
}
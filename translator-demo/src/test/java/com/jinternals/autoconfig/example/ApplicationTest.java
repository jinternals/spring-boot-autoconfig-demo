package com.jinternals.autoconfig.example;

import com.jinternals.autoconfig.example.dto.TranslatorRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.jinternals.autoconfig.example.controllers.TranslatorTestHelper.toJson;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {


    @Autowired
    private MockMvc mvc;


    @Test
    public void shouldTranslateTextFromEnglishToSpanish() throws Exception {
        TranslatorRequest translatorDTO = new TranslatorRequest("hello", "en", "es");

        mvc.perform(post("/api/translator")
                .contentType(APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(translatorDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text", is("hola")))
                .andDo(print());

    }
}
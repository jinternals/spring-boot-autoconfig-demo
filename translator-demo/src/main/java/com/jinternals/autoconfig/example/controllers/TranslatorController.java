package com.jinternals.autoconfig.example.controllers;

import com.jinternals.autoconfig.example.dto.TranslatorRequest;
import com.jinternals.autoconfig.example.dto.TranslatorResponse;
import com.jinternals.translator.component.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/translator")
public class TranslatorController {

    private Translator translator;

    @Autowired
    public TranslatorController(Translator translator){
        this.translator = translator;
    }

    @RequestMapping(method = POST)
    public TranslatorResponse translate(@RequestBody TranslatorRequest request){
       String result = translator.translate(request.getText(),request.getFrom(),request.getTo());
       return new TranslatorResponse(result);
    }
}

package com.jinternals.autoconfig.example;

import com.jinternals.translator.component.Translator;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            try {
//                Translator translator = ctx.getBean(Translator.class);
//                String text = translator.translate("Hello","en","es");
//                System.out.println(text);
//            } catch (NoSuchBeanDefinitionException e) {
//                System.err.println("No bean of type Translator found.");
//            }
//
//
//        };
//    }

}

package com.jinternals.translator.autoconfig;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.jinternals.translator.component.Translator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Translate.class)
@EnableConfigurationProperties(TranslatorConfiguration.class)
public class TranslatorAutoConfiguration {

    private final TranslatorConfiguration configuration;

    public TranslatorAutoConfiguration(TranslatorConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    @ConditionalOnMissingBean
    //@Conditional(TranslatorConfigurationCondition.class)
    @ConditionalOnTranslatorEnabledConfigProperty
    public Translator getTranslator() {
        return new Translator( TranslateOptions.newBuilder().setApiKey(configuration.getKey()).build().getService());
    }

}

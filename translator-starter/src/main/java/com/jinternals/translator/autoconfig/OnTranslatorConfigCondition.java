package com.jinternals.translator.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnTranslatorConfigCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(context.getEnvironment(), "translator.");
        ConditionMessage.Builder condition = ConditionMessage.forCondition("Translator");

        TranslatorConfiguration translatorConfiguration = new TranslatorConfiguration();

        if (resolver.getProperty("enabled", Boolean.class,translatorConfiguration.isEnabled())) {
            return ConditionOutcome.match();
        }
        return ConditionOutcome.noMatch(condition.because("is not enabled"));

    }

}

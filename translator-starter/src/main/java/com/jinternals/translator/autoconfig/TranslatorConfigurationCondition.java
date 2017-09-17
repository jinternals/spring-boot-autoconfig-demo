package com.jinternals.translator.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static java.lang.String.format;
import static org.springframework.boot.autoconfigure.condition.ConditionOutcome.match;
import static org.springframework.boot.autoconfigure.condition.ConditionOutcome.noMatch;

class TranslatorConfigurationCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(context.getEnvironment(), "translator.");
        ConditionMessage.Builder condition = ConditionMessage.forCondition(ConditionalOnTranslatorEnabledConfigProperty.class);

        TranslatorConfiguration translatorConfiguration = new TranslatorConfiguration();
        Boolean value = resolver.getProperty("enabled", Boolean.class, translatorConfiguration.isEnabled());
        if (value) {
            return match(condition.available(format("translator.enable : %s", value)));
        }
        return noMatch(condition.because(format("translator.enable : %s", value)));

    }

}

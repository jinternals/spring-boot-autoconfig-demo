package com.jinternals.translator.autoconfig;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(TranslatorConfigurationCondition.class)
public @interface ConditionalOnTranslatorEnabledConfigProperty {
}

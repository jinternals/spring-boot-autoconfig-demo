package com.jinternals.translator.autoconfig;


import com.jinternals.translator.component.Translator;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TranslatorAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void shouldLoadTranslator() throws Exception {
        load(EmptyConfiguration.class);
        Translator translator = this.context.getBean(Translator.class);
        Assert.notNull(translator.getTranslate(),"The getTranslate must not return null");
        assertEquals(1, this.context.getBeansOfType(Translator.class).size());
    }

    @Test
    public void shouldLoadTheCustomTranslator() throws Exception {
        load(CustomTranslatorAutoConfiguration.class);
        Translator translator = this.context.getBean(Translator.class);
        assertEquals(null, translator.getTranslate());
        assertEquals(1, this.context.getBeansOfType(Translator.class).size());
    }

    @Test
    public void shouldLoadTranslatorBeanIfPropertyIsEnabled() throws Exception {
        load(EmptyConfiguration.class, "translator.enabled=true");
        assertEquals(1, this.context.getBeansOfType(Translator.class).size());
    }

    @Test
    public void shouldNotLoadTranslatorBeanIfDisabled() throws Exception {
        load(EmptyConfiguration.class, "translator.enabled=false");
        assertThat(this.context.getBeansOfType(Translator.class)).isEmpty();
    }


    @Configuration
    static class EmptyConfiguration {
    }

    @Configuration
    static class CustomTranslatorAutoConfiguration {
        @Bean
        public Translator loggerInjectorBeanPostProcessor() {
            return new Translator(null, null, null);
        }
    }

    private void load(Class<?> config, String... environment) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        EnvironmentTestUtils.addEnvironment(applicationContext, environment);
        applicationContext.register(config);
        applicationContext.register(TranslatorAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}
package com.jinternals.translator.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("translator")
public class TranslatorConfiguration {

    /**
     * Key for google translate api.
     */
    private String key;

    /**
     * enabled or disable translator.
     */
    private boolean enabled = true;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}

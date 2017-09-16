package com.jinternals.translator.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("translator")
public class TranslatorConfiguration {

    /**
     * Source language.
     */
    private String from ;

    /**
     * Target language.
     */
    private String to ;

    /**
     * Key for google translate api.
     */
    private String key;


    private boolean enabled = true;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

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

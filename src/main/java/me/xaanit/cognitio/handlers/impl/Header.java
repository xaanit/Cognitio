package me.xaanit.cognitio.handlers.impl;

/**
 * Created by Jacob on 5/9/2017.
 */
public class Header {
    private String key;
    private String value;

    public Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}

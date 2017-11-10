package com.geforce.security.core.properties;

/**
 * @author geforce
 * @date 2017/11/10
 */
public class ImageCodeProperties extends SmsCodeProperties {
    private int width = 67;
    private int height = 23;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public ImageCodeProperties() {
        setLength(4);
    }
}

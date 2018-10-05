package com.codingblocks.planet;

import android.support.v7.app.AppCompatActivity;

public class Imageclass {

    private String title,subtitle,url;

    public Imageclass(String title, String subtitle, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


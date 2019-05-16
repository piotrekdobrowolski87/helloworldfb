package com.pdobrowolski.helloworldfb.pages;

public abstract class Page {

    private String url = "";
    private String title = "";

    protected void setUrl(String url) {
        this.url = url;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    //online_1
    //online_2
}

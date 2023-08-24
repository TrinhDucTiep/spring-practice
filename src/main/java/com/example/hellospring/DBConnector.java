package com.example.hellospring;

public abstract class DBConnector {

    private String url;

    public abstract void connect();

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

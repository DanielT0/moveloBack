package com.movelo.moveloapp.api;

public class NotificationContent {
    private String en;
    private String es;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public NotificationContent(String en, String es) {
        this.en = en;
        this.es = es;
    }

}

package com.movelo.moveloapp.models;

import java.util.Date;

public class RegistroGeografico extends PuntoGeografico {

    private Date timeStamp;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}

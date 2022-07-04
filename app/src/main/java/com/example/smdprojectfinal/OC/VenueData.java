package com.example.smdprojectfinal.OC;

import java.sql.Time;

public class VenueData {
    String place,time;

    public VenueData(String place, String time) {
        this.place = place;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.example.smdprojectfinal.OC;

public class ParticipantsData {
    String Name,Event,Institute;

    public ParticipantsData(String name, String event, String institute) {
        Name = name;
        Event = event;
        Institute = institute;
    }


    public ParticipantsData() {
    }
    public String getName() {
        return Name;
    }

    public String getEvent() {
        return Event;
    }

    public String getInstitute() {
        return Institute;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public void setInstitute(String institute) {
        Institute = institute;
    }
}

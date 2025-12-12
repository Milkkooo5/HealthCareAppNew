package com.example.healthcareapp.data.model;

public class Doctor {
    private String id;
    private String name;
    private String last_name;
    private String otchestvo;
    private String experience;
    private String specialty;

    public Doctor(){};

    public Doctor(String id,String name, String last_name,String otchestvo, String experience, String specialty){
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.otchestvo = otchestvo;
        this.experience = experience;
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public String getExperience() {
        return experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}

package com.example.healthcareapp.ViewModels;

import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
    private String name = "";
    private String surname = "";
    private String patronymic = "";
    private String omsNumber = "";
    private String birthDate = "";

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getOmsNumber() { return omsNumber; }
    public void setOmsNumber(String omsNumber) { this.omsNumber = omsNumber; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
}

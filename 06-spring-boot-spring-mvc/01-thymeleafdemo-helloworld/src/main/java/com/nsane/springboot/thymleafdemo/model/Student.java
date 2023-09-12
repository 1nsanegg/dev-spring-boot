package com.nsane.springboot.thymleafdemo.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;

    private String Country;

    private String favouriteLanguage;
    private List<String> favouriteSystem;

    public Student() {

    }

    public List<String> getFavouriteSystem() {
        return favouriteSystem;
    }

    public void setFavouriteSystem(List<String> favouriteSystem) {
        this.favouriteSystem = favouriteSystem;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

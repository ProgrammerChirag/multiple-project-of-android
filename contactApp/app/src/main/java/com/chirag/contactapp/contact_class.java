package com.chirag.contactapp;

public class contact_class {
    String name , number , about;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public contact_class(){

    }
    public contact_class(String name, String number, String about) {
        this.name = name;
        this.number = number;
        this.about = about;
    }
}

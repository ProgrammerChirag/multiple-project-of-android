package com.chirag.noticeboard;

public class notes {
    String description,name , time   , title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public notes(String name, String time, String description, String title) {
        this.name = name;
        this.time = time;
        this.description = description;
        this.title = title;
    }
    private notes(){

    }
}

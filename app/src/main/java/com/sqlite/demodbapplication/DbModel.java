package com.sqlite.demodbapplication;

public class DbModel {
    DbModel(String title, int priority, int id) {
        this.title = title;
        this.priority = priority;
        this.id = id;
    }

    String title;
    int priority;
    int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

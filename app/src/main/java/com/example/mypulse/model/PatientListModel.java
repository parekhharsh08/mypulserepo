package com.example.mypulse.model;

import android.media.Image;

public class PatientListModel  {
    String name;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public PatientListModel(String name, int image) {
        this.name = name;
        this.image = image;
    }
    public PatientListModel() {
        this.name = name;
        this.image = image;
    }
}

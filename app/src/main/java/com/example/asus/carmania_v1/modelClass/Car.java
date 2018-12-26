package com.example.asus.carmania_v1.modelClass;

public class Car
{
    private String carName;
    private String model;
    private String color;


    public Car(String carName, String model, String color) {
        this.carName = carName;
        this.model = model;
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

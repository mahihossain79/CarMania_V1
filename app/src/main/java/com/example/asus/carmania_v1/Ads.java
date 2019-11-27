package com.example.asus.carmania_v1;

public class Ads {
    private String carName;
    private String carType;
    private String color;
    private String engineCapacity;
    private String model;
    private String price;
    private String seatCapacity;
    private String phone;
    private String imageurl;
    private boolean permission;



    public Ads(String carName, String carType, String color, String engineCapacity, String model, String price, String seatCapacity, String phone, String imageurl) {
        this.carName = carName;
        this.carType = carType;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.model = model;
        this.price = price;
        this.seatCapacity = seatCapacity;
        this.phone = phone;
        this.imageurl = imageurl;
    }


    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(String seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public Ads() {
    }
}

package com.example.asus.carmania_v1.modelClass;

public class RentAds {
    private String carName;
    private String carType;
    private String location;
    private String seatCapacity;
    private String phone;
    private String imageurl;


    public RentAds(String carName, String carType, String location, String seatCapacity, String phone, String imageurl) {
        this.carName = carName;
        this.carType = carType;
        this.location = location;
        this.seatCapacity = seatCapacity;
        this.phone = phone;
        this.imageurl = imageurl;
    }

    public RentAds() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}

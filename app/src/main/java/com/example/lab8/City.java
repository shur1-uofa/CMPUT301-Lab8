package com.example.lab8;

public class City {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object obj) {
        City toCompare = (City) obj;
        return toCompare.getCityName().equals(city) && toCompare.getProvinceName().equals(province);
    }
}

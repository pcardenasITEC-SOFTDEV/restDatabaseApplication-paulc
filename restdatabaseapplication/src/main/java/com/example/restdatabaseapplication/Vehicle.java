package com.example.restdatabaseapplication;

import javax.persistence.*;

@Entity
@Table(name="vehicleData")
public class Vehicle{
    @Id
    private int id;
    private String makeModel;
    private int year;
    private double retailPrice;

    public Vehicle(){
        this.id = id;
        this.makeModel = makeModel;
        this.year = year;
        this.retailPrice = retailPrice;
    }

    public Vehicle(int id, String makeModel, int year, double retailPrice) {
        this.id = id;
        this.makeModel = makeModel;
        this.year = year;
        this.retailPrice = retailPrice;
    }


    public String toString(){
        return this.getId() + ", " + this.getMakeModel() + ", Year: " + this.year + ", Price: " + this.retailPrice;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }
}

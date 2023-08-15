package com.study.houserent.database;

public class House {
    private int id;
    private String name;
    private int phoneNumber;
    private String address;
    private double monthRent;
    private String status;

    public House() {
    }

    public House(int id, String name, int phoneNumber, String address, double monthRent, String status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.monthRent = monthRent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(double monthRent) {
        this.monthRent = monthRent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t" + phoneNumber +
                "\t\t" + address +
                "\t" + monthRent +
                "\t" + status;
    }
}

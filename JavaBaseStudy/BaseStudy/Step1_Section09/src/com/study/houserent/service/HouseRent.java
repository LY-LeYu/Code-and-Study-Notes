package com.study.houserent.service;

import com.study.houserent.database.House;

public class HouseRent {
    private House[] house;

    public HouseRent(int size) {
        this.house = new House[size];
        house[0] = new House(2, "jack", 112, "未央区",
                5000, "未出租");
        house[1] = new House(3, "jayy", 122, "未央区",
                4000, "未出租");
    }

    public boolean addHouse(House house) {

        for (int i = 0; i < this.house.length; i++) {
            /*if (i == this.house.length-1) { //数组已满，需要扩容
                System.out.println("数组已满，需要扩容");
                House[] clonehouse = new House[this.house.length + 1];
                for (int j = 0; j < this.house.length; j++) {
                    clonehouse[i] = this.house[i];
                }
                this.house = clonehouse;
            }*/
            if (this.house[i] == null) {
                house.setId(i);
                this.house[i] = house;
                return true;
            }
        }

        return false;
    }

    public void deleteHouse(int id) {
        House[] newHouse = new House[this.house.length];
        for (int i = 0,j = 0; i < this.house.length; i++,j++) {
            if (this.house[j] == null) {
                break;
            }
            if (j != id) {
                newHouse[i] = this.house[j];
            } else {
                newHouse[i] = this.house[++j];
            }
        }
        this.house = newHouse;
    }

    public void updateHouse(House house, int id) {
        this.house[id] = house;
    }

    public House[] getHouse() {
        //编号检测机制
        for (int i = 0; i < this.house.length; i++) {
            if (this.house[i] == null) {
                break;
            }
            this.house[i].setId(i);
        }
        return house;
    }
}

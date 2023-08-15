package com.study.houserent;

import com.study.houserent.database.House;
import com.study.houserent.service.HouseRent;
import com.study.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {

        HouseView view = new HouseView();
        view.showMenu();
    }
}

package com.study.houserent.view;

import com.study.houserent.database.House;
import com.study.houserent.service.HouseRent;
import com.study.houserent.utils.Utility;

public class HouseView {
    private boolean flag = true;
    private char key;
    HouseRent houseRent = new HouseRent(100);

    public void showMenu() {

        do {
            System.out.println("--------------- 房屋出租系统 ---------------");
            System.out.println("\t\t\t\t1 新增房源");
            System.out.println("\t\t\t\t2 查找房屋");
            System.out.println("\t\t\t\t3 删除房屋");
            System.out.println("\t\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t\t5 房屋列表");
            System.out.println("\t\t\t\t6 退   出");
            System.out.print("请输入你的选择（1 - 6）:");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    showAddHouse();
                    break;
                case '2':
                    showFindHouse();
                    break;
                case '3':
                    showDeleteHouse();
                    break;
                case '4':
                    showUpdateHouse();
                    break;
                case '5':
                    showHouseList();
                    break;
                case '6':
                    quit();
                    break;
                default:
                    System.out.println("指令有误");

            }

        } while (flag);


    }

    public void showHouseList() {

        System.out.println("----------------  房屋信息  ----------------");
        System.out.println("编号" +
                "\t\t" + "房主" +
                "\t\t" + "电话" +
                "\t\t" + "地址" +
                "\t\t" + "月租" +
                "\t\t" + "状态(是否出租)");
        House[] houses = houseRent.getHouse();
        for (House i : houses) {
            if (i == null) {
                break;
            }
            System.out.println(i);

        }
        System.out.println("------------------- 完成 -------------------");

    }

    public void showAddHouse() {
        House house = new House();
        System.out.println("----------------  添加房屋  ----------------");
        System.out.print("姓名：");
        house.setName(Utility.readString(5, "none"));
        System.out.print("电话：");
        house.setPhoneNumber(Utility.readInt());
        System.out.print("地址：");
        house.setAddress(Utility.readString(20));
        System.out.print("月租：");
        house.setMonthRent(Utility.readInt(5));
        System.out.print("状态：");
        house.setStatus(Utility.readString(4));
        if (houseRent.addHouse(house)) {
            System.out.println("----------------  添加成功  ----------------");
        } else {
            System.out.println("----------------  添加失败  ----------------");

        }
    }

    public void showDeleteHouse() {
        System.out.println("--------------  删除房屋信息  ---------------");
        System.out.print("请输入待删除房屋编号（-1退出）：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }
        System.out.print("确认是否删除（Y/N），请务必小心：");
        char confirm = Utility.readConfirmSelection();
        System.out.print("是否删除（Y/N）：");
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            houseRent.deleteHouse(id);
            System.out.println("--------------  删除成功  ---------------");
        }

    }

    public void showUpdateHouse() {
        System.out.println("--------------  修改房屋信息  ---------------");
        System.out.print("请输入待修改房屋编号（-1退出）：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }
        House house = houseRent.getHouse()[id];
        if (house == null) {
            System.out.println("----------输入的编号无对应房屋信息------------");
        } else {
            System.out.print("姓名：");
            house.setName(Utility.readString(5, "none"));
            System.out.print("电话：");
            house.setPhoneNumber(Utility.readInt());
            System.out.print("地址：");
            house.setAddress(Utility.readString(20));
            System.out.print("月租：");
            house.setMonthRent(Utility.readInt(5));
            System.out.print("状态：");
            house.setStatus(Utility.readString(4));
            houseRent.updateHouse(house,id);
            System.out.println("--------------  修改成功  ---------------");
        }
    }

    public void showFindHouse() {
        System.out.println("--------------  查找房屋信息  ---------------");
        System.out.print("请输入待查找房屋编号（-1退出）：");
        int id = Utility.readInt();
        if (id == -1) {
            return;
        }
        House house = houseRent.getHouse()[id];
        if (house == null) {
            System.out.println("----------输入的编号无对应房屋信息------------");
        } else {
            System.out.println("编号" +
                    "\t\t" + "房主" +
                    "\t\t" + "电话" +
                    "\t\t" + "地址" +
                    "\t\t" + "月租" +
                    "\t\t" + "状态(是否出租)");
            System.out.println(house);
            System.out.println("--------------  查找完成  ---------------");
        }
    }

    public void quit() {
        System.out.println("请确认是否退出（Y/N）：");
        char confirm = Utility.readConfirmSelection();
        System.out.println("是否退出（Y/N）：");
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            flag = false;
        }
    }
}

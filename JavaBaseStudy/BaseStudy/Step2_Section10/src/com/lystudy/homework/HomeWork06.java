package com.lystudy.homework;

public class HomeWork06 {
    public static void main(String[] args) {
        Person TS = new Person("唐僧");
        TS.commom();
        System.out.println(TS.getVehicles());
        TS.passRiver();
        System.out.println(TS.getVehicles());
        TS.commom();
        System.out.println(TS.getVehicles());
        TS.passRiver();
        System.out.println(TS.getVehicles());

    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    public void work() {
        System.out.println("白龙马在地上跑");
    }
}

class Boat implements Vehicles {
    public void work() {
        System.out.println("船在水上漂");
    }
}

class VehicleFactory {
    private static Vehicles horse = new Horse();

    public static Vehicles getHorse() {
        return horse;
    }

    public static Vehicles getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name) {
        this.name = name;
    }

    public void commom() {
        this.vehicles = VehicleFactory.getHorse();
        vehicles.work();
    }

    public void passRiver() {
        if (!(this.vehicles instanceof Boat)) {
            this.vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }

    public Vehicles getVehicles() {
        return vehicles;
    }
}

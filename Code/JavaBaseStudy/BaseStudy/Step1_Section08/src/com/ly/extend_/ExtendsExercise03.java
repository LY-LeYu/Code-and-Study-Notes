package com.ly.extend_;

/**
 * @author  ly
 * @version v0.1
 * $Date$
 */
public class ExtendsExercise03 {
    public static void main(String[] args) {
        Pc pc = new Pc("R9 5900X", "DDR5 3200HZ", "Samsung 980 Evo", "ROG");
        Laptop laptop = new Laptop("R9 5900X", "DDR5 3200HZ", "Samsung 980 Evo", "R9 5900HX");
        System.out.println("台式：");
        pc.showInfo();
        System.out.println("笔记本：");
        laptop.showInfo();
    }
}

class Computer {
    String cpu;
    String ddr;
    String qlc;

    public Computer() {
    }

    public Computer(String cpu, String ddr, String qlc) {
        this.cpu = cpu;
        this.ddr = ddr;
        this.qlc = qlc;
    }

    public void showInfo() {
        System.out.println("CPU:" + cpu + "\t" + "DDR:" + ddr + "\t" + "QLC:" + qlc);
    }
}

class Pc extends Computer {
    String brand;

    public Pc() {
    }

    public Pc(String cpu, String ddr, String qlc, String brand) {
        super(cpu, ddr, qlc);
        this.brand = brand;
    }
}

class Laptop extends Computer {
    String cpu;

    public Laptop() {
    }

    public Laptop(String cpu, String ddr, String qlc, String new_cpu) {
        super(cpu, ddr, qlc);
        this.cpu = new_cpu;
    }
}
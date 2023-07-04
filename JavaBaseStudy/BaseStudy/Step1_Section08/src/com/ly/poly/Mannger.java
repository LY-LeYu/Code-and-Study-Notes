package com.ly.poly;

public class Mannger extends Employee {
    double bonus;

    public Mannger(String name, Double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary()+bonus;
    }

    public void mannger() {
        System.out.println("经理正在管理");
    }
}

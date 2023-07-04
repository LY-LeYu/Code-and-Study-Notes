package com.ly.poly;

public class Worker extends Employee {
    public Worker(String name, Double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("员工正在工作");
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary();
    }
}

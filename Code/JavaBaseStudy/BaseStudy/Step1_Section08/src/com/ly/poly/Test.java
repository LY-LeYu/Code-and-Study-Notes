package com.ly.poly;

public class Test {
    public static void main(String[] args) {
        Worker jay = new Worker("jay", 8000.0);
        Mannger lily = new Mannger("Lily", 12000.0, 50000);
        Test test = new Test();
        test.showEmployeeAnnualSalary(jay);
        test.showEmployeeAnnualSalary(lily);
        test.employeeWork(jay);
        test.employeeWork(lily);
        new Object();
}

    public void showEmployeeAnnualSalary(Employee employee) {
        System.out.println(employee.getAnnualSalary());
    }

    public void employeeWork(Employee employee) {
        if (employee instanceof Worker) {
            ((Worker) employee).work();
        } else if (employee instanceof Mannger) {
            ((Mannger) employee).mannger();
        }
    }

}

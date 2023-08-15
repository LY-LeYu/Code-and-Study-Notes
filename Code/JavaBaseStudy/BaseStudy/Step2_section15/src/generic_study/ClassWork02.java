package generic_study;

import java.util.ArrayList;
import java.util.Comparator;

public class ClassWork02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee<MyDate> jay = new Employee<MyDate>("ajay", 50000.1, new MyDate(2000, 1, 3));
        Employee<MyDate> rose = new Employee<MyDate>("arose", 20000.1, new MyDate(2000, 1, 2));
        Employee<MyDate> mary = new Employee<MyDate>("amary", 2000000.1, new MyDate(2000, 1, 1));
        employees.add(jay);
        employees.add(rose);
        employees.add(mary);
        System.out.println("未排序：");
        System.out.println(employees);
        employees.sort(new Comparator<Employee>() { //此时Employee没有指定MyDate类，所以接下来的Birthday是Object编译类型
            @Override
            public int compare(Employee o1, Employee o2) {
//                int i = o1.getName().compareTo(o2.getName());
//                if (i != 0) {
//                    return i;
//                }
                return ((MyDate) o1.getBirthday()).compareTo((MyDate) o2.getBirthday());

//                MyDate b1 = (MyDate) o1.getBirthday();
//                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println("排序后：");
        System.out.println(employees);
    }
}

class Employee<E> {
    private String name;
    private double salary;
    E birthday;

    public Employee(String name, double sal, E birthday) {
        setName(name);
        setSalary(sal);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public E getBirthday() {
        return birthday;
    }

    public void setBirthday(E birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}


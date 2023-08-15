package generic_study;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("月份错误");
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new RuntimeException("日期错误");
        }
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public MyDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);

    }

    @Override
    public int compareTo(MyDate o) {
        if (this.year - o.getYear() != 0) {
            return this.year - o.getYear();
        }
        if (this.month - o.getMonth() != 0) {
            return this.month - o.getMonth();
        }
        if (this.day - o.getDay() != 0) {
            return this.day - o.getDay();
        }
        return 0;
    }
}

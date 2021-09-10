package model;

import java.util.Calendar;
import java.util.Objects;

public class Employee {
    private int clearSalary;
    private String name;
    private final Calendar birthday = Calendar.getInstance();

    private int prize;
    private int raise;

    public void setClearSalary(int clearSalary) {
        this.clearSalary = clearSalary;
    }

    public void setBirthday(int year, int month, int day) {
        this.birthday.set(year, month, day);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void setRaise(int raise) {
        this.raise = raise;
    }

    public int getClearSalary() {
        return clearSalary;
    }

    public String getName() {
        return name;
    }

    public int getThisMonthSalary(){
        return clearSalary + prize + raise;
    }

    public boolean isBirthdayThisMonth(int month){
        return birthday.get(Calendar.MONTH) == month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name)
                && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

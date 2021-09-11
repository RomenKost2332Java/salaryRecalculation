package model.payroll;

import java.util.*;

public abstract class Payroll {
    private int prize;
    private int month;

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws RuntimeException {
        month--;
        if (month < Calendar.JANUARY || Calendar.DECEMBER < month){
            throw new RuntimeException();
        }
        this.month = month;
    }
}

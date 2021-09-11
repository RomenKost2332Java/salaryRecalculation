package model.payroll;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DepartmentPayroll extends Payroll {
    private final Map<String, Integer> payrollMap = new HashMap<>();

    public void addPayroll(String department, int payroll){
        payrollMap.put(department, payroll);
    }

    public Set<String> getDepartmentsNames(){
        return payrollMap.keySet();
    }

    public int getPayroll(String department) {
        return payrollMap.get(department);
    }
}

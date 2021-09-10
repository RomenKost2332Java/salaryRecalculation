package model;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private final Map<String, Department> departments = new HashMap<>();

    public Map<String, Department> getDepartments(){
        return new HashMap<>(departments);
    }

    public void addDepartment(Department department, String name){
        departments.put(name, department);
    }

    public void addEmployee(String department, Employee employee){
        departments.get(department).addEmployee(employee);
    }

    public int countEmployee(){
        return departments.values()
                .stream()
                .mapToInt(Department::countEmployee)
                .sum();
    }

    public int countEmployeeWithBirthdayThisMonth(int month){
        return departments.values()
                .stream()
                .mapToInt(department -> department.countEmployeeWithBirthdayThisMonth(month))
                .sum();
    }

    public int sumClearSalary(){
        return departments.values()
                .stream()
                .mapToInt(Department::sumClearSalary)
                .sum();
    }
}

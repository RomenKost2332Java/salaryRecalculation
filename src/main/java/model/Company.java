package model;

import java.util.HashSet;
import java.util.Set;

public class Company {
    private final Set<Department> departments = new HashSet<>();
    private final Set<Employee> employees = new HashSet<>();

    public Set<Department> getDepartments(){
        return new HashSet<>(departments);
    }

    public Set<Employee> getEmployees() {
        return new HashSet<>(employees);
    }

    public boolean addDepartment(Department department){
        employees.addAll(department.getEmployees());
        return departments.add(department);
    }

    public boolean addDepartments(Set<Department> departments){
        departments.forEach(department ->
                employees.addAll(department.getEmployees())
        );
        return this.departments.addAll(departments);
    }
}

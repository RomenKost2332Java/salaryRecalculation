package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {
    private final Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployees(){
        return new HashSet<>(employees);
    }

    public boolean addEmployee(Employee employee){
        return employees.add(employee);
    }

    public boolean addEmployees(Set<Employee> employees){
        return this.employees.addAll(employees);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }
}

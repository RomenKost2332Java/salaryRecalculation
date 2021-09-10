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

    public int countEmployee(){
        return employees.size();
    }

    public int countEmployeeWithBirthdayThisMonth(int month){
        return (int) employees.stream()
                .filter(employee -> employee.isBirthdayThisMonth(month))
                .count();
    }

    public int sumClearSalary(){
        return employees.stream()
                .mapToInt(Employee::getClearSalary)
                .sum();
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

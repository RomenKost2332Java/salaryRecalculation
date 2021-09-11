package controller.payroll;

import model.Company;
import model.Department;
import model.payroll.DepartmentPayroll;

import java.util.Map;

public class DepartmentPayrollCalculator extends PayrollCalculator {
    private final Company company;
    private final DepartmentPayroll payroll;

    DepartmentPayrollCalculator(Company company, DepartmentPayroll companyPayroll) {
        super(company);
        this.company = company;
        this.payroll = companyPayroll;
        checkPayroll();
    }

    private void checkPayroll(){
        boolean status = company.getDepartmentsNames().equals(payroll.getDepartmentsNames())
                && company.getDepartmentsStream()
                .allMatch(department ->
                        calculateBalance(department) >= 0
                );

        if (!status) {
            throw new RuntimeException();
        }
    }

    private int calculateBalance(Map.Entry<String, Department> department){
        int birthdayPrize = payroll.getPrize()
                * department.getValue()
                        .countEmployeeWithBirthdayThisMonth(payroll.getMonth());
        return payroll.getPayroll(department.getKey())
                - birthdayPrize
                - department.getValue().sumClearSalary();
    }

    @Override
    public void recalculateSalaryEqual() {
        company.getDepartmentsStream()
                .forEach(department -> {
                    int raise = payroll.getPayroll(department.getKey())
                            / department.getValue().countEmployee();
                    department.getValue()
                            .getEmployeesStream()
                            .forEach(employee -> employee.setRaise(raise));
                });
    }

    @Override
    public void recalculateSalaryProportional() {
        company.getDepartmentsStream()
                .forEach(department -> {
                    double raiseRatio = (double) calculateBalance(department)
                            / department.getValue().sumClearSalary();
                    department.getValue()
                            .getEmployeesStream()
                            .forEach(employee ->
                                    employee.setRaise((int) (raiseRatio * employee.getClearSalary()))
                            );
                });
    }
}

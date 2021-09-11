package controller.payroll;

import model.Company;
import model.payroll.CompanyPayroll;

public class CompanyPayrollCalculator extends PayrollCalculator {
    private final Company company;
    private final CompanyPayroll payroll;

    CompanyPayrollCalculator(Company company, CompanyPayroll companyPayroll) {
        super(company);
        this.company = company;
        this.payroll = companyPayroll;
        checkPayroll();
    }

    private void checkPayroll(){
        int balance = calculateBalance();
        if (balance < 0) {
            throw new RuntimeException();
        }
    }

    private int calculateBalance() {
        int birthdayPrize = payroll.getPrize() * company.countEmployeeWithBirthdayThisMonth(payroll.getMonth());
        return payroll.getPayroll() - birthdayPrize - company.sumClearSalary();
    }

    @Override
    public void recalculateSalaryEqual() {
        int raise = calculateBalance() / company.countEmployee();
        company.getDepartmentsStream()
                .forEach(department ->
                    department.getValue()
                            .getEmployeesStream()
                            .forEach(employee ->
                                employee.setRaise(raise)
                            )
                );
    }

    @Override
    public void recalculateSalaryProportional() {
        double raiseRatio = (double) company.sumClearSalary() / calculateBalance();
        company.getDepartmentsStream()
                .forEach(department ->
                        department.getValue()
                                .getEmployeesStream()
                                .forEach(employee ->
                                        employee.setRaise((int) (raiseRatio * employee.getClearSalary()))
                                )
                );
    }
}

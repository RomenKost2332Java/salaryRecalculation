package controller.payroll;

import model.Company;
import model.payroll.CompanyPayroll;
import model.payroll.DepartmentPayroll;

public abstract class PayrollCalculator {
    Company company;

    public PayrollCalculator(Company company){
        this.company = company;
    }

    public static PayrollCalculator getInstance(Company company, CompanyPayroll payroll){
        return new CompanyPayrollCalculator(company, payroll);
    }

    public static PayrollCalculator getInstance(Company company, DepartmentPayroll payroll){
        return new DepartmentPayrollCalculator(company, payroll);
    }

    public abstract void recalculateSalaryEqual();

    public abstract void recalculateSalaryProportional();
}

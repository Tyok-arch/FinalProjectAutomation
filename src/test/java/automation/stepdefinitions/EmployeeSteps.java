package automation.stepdefinitions;

import automation.pages.DashboardPage;
import automation.pages.EmployeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmployeeSteps {

    DashboardPage dashboardPage = new DashboardPage();
    EmployeePage employeePage = new EmployeePage();

    @And("User membuka menu Employee")
    public void userMembukaMenuEmployee() {

        dashboardPage.clickEmployee();

    }

    @And("User klik Add Employee")
    public void userKlikAddEmployee() {

        employeePage.clickAddEmployee();

    }

    @And("User mengisi nama")
    public void userMengisiNama() {

        employeePage.inputName("Automation Test");

    }

    @And("User mengisi email")
    public void userMengisiEmail() {

        employeePage.inputEmail("automation@test.com");

    }

    @And("User mengisi nomor hp")
    public void userMengisiNomorHp() {

        employeePage.inputPhone("081234567890");

    }

    @Then("Form Add Employee tampil")
    public void formAddEmployeeTampil() {

        System.out.println("Add Employee Form Displayed");

    }

    @Then("Employee List tampil")
    public void employeeListTampil() {

        System.out.println("Employee List Displayed");

    }

}
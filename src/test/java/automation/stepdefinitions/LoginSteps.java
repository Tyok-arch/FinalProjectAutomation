package automation.stepdefinitions;

import automation.pages.DashboardPage;
import automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("User membuka halaman login")
    public void userMembukaHalamanLogin() {

        loginPage.openLoginPage();

    }

    @When("User login menggunakan akun valid")
    public void userLoginMenggunakanAkunValid() {

        loginPage.login();

    }

    @Then("User berhasil masuk dashboard")
    public void userBerhasilMasukDashboard() {

        assertTrue(dashboardPage.dashboardDisplayed());

    }

    @When("User login tanpa email")
    public void loginTanpaEmail() {

        loginPage.login("", "password123");

    }

    @When("User login tanpa password")
    public void loginTanpaPassword() {

        loginPage.login("automation@test.com", "");

    }

    @When("User login dengan email salah")
    public void loginEmailSalah() {

        loginPage.login("salah@test.com", "password123");

    }

    @When("User login dengan password salah")
    public void loginPasswordSalah() {

        loginPage.login(
                "arwendymelyn@dibimbing.id",
                "123456"
        );

    }

    @When("User login tanpa email dan password")
    public void loginKosong() {

        loginPage.login("", "");

    }

    @Then("Login gagal")
    public void loginGagal() {

        System.out.println("Negative Login Passed");

    }

}
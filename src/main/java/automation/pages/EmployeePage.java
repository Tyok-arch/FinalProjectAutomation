package automation.pages;

import automation.locators.EmployeeLocator;

public class EmployeePage extends BasePage {

    /**
     * Click Add Employee button.
     */
    public void clickAddEmployee() {

        click(EmployeeLocator.ADD_EMPLOYEE_BUTTON);

    }

    /**
     * Input employee name.
     */
    public void inputName(String name) {

        type(EmployeeLocator.FORM_NAME, name);

    }

    /**
     * Input employee email.
     */
    public void inputEmail(String email) {

        type(EmployeeLocator.FORM_EMAIL, email);

    }

    /**
     * Input employee phone number.
     */
    public void inputPhone(String phone) {

        type(EmployeeLocator.FORM_PHONE, phone);

    }

    /**
     * Input employee role.
     */
    public void inputRole(String role) {

        type(EmployeeLocator.FORM_ROLE, role);

    }

    /**
     * Input employee address.
     */
    public void inputAddress(String address) {

        type(EmployeeLocator.FORM_ADDRESS, address);

    }

    /**
     * Input employee NIK.
     */
    public void inputNik(String nik) {

        type(EmployeeLocator.FORM_NIK, nik);

    }

    /**
     * Input employee NPWP.
     */
    public void inputNpwp(String npwp) {

        type(EmployeeLocator.FORM_NPWP, npwp);

    }

    /**
     * Select Male gender.
     */
    public void chooseMale() {

        click(EmployeeLocator.FORM_GENDER_MALE);

    }
    /**
     * Add employe
     */
    public boolean employeeListDisplayed(){

        return isDisplayed(EmployeeLocator.ADD_EMPLOYEE_BUTTON);

    }

    public void clickClose(){

        click(EmployeeLocator.CLOSE_BUTTON);

    }
}
package automation.locators;

import org.openqa.selenium.By;

/**
 * Locators for the Employee page.
 * Contains locators for Employee List and Add Employee form.
 */
public final class EmployeeLocator {

    private EmployeeLocator() {}

    // ==========================================================
    // Employee List
    // ==========================================================

    /** Employee menu on sidebar. */
    public static final By MENU_EMPLOYEE =
            By.xpath("//*[@id='layout-desktop-menu-item-box-employee']/div/p");

    /** Add Employee button. */
    public static final By ADD_EMPLOYEE_BUTTON =
            By.id("button-add-employee");

    /** Employee search input. */
    public static final By SEARCH_INPUT =
            By.cssSelector("#input-admin-employee-search input");

    /** Employee list counter. */
    public static final By EMPLOYEE_LIST_COUNT =
            By.id("employee-list-count");

    // ==========================================================
    // Add Employee Form
    // ==========================================================

    /** Employee Name input. */
    public static final By FORM_NAME =
            By.id("name");

    /** Employee Email input. */
    public static final By FORM_EMAIL =
            By.id("email");

    /** Employee Phone Number input. */
    public static final By FORM_PHONE =
            By.id("phoneNumber");

    /** Program Studi dropdown. */
    public static final By FORM_PROGRAM_STUDI =
            By.id("division");

    /** Angkatan dropdown. */
    public static final By FORM_ANGKATAN =
            By.xpath("//*[@id='menu-button-:r7v:']");

    /** Employee Role input. */
    public static final By FORM_ROLE =
            By.id("employeeRole");

    /** Male gender radio button. */
    public static final By FORM_GENDER_MALE =
            By.xpath("//*[@id='chakra-modal--body-:r7h:']/div[1]/div[8]/div/div/div/label[1]");

    /** Date of Birth input. */
    public static final By FORM_DATE_OF_BIRTH =
            By.id("dateOfBirth");

    /** Address input. */
    public static final By FORM_ADDRESS =
            By.id("address");

    /** NIK input. */
    public static final By FORM_NIK =
            By.id("nik");

    /** NPWP input. */
    public static final By FORM_NPWP =
            By.id("npwp");

    /** Submit button. */
    public static final By FORM_SUBMIT =
            By.id("button-add-employee-submit");

    // ==========================================================
    // Validation
    // ==========================================================

    /** Toast message displayed after submit. */
    public static final By TOAST_ALERT =
            By.cssSelector("[role='alert']");

    /** Close button Add Employee modal. */
    public static final By CLOSE_BUTTON =
            By.cssSelector("button[aria-label='Close']");
}
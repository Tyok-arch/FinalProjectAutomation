package automation.locators;

import org.openqa.selenium.By;

/**
 * Locators for the Login page.
 * This page is responsible for user authentication.
 */
public final class LoginLocator {

    private LoginLocator() {}

    /** Email / Username input field. */
    public static final By EMAIL_INPUT =
            By.id("input-username-or-email");

    /** Password input field. */
    public static final By PASSWORD_INPUT =
            By.id("input-password");

    /** Sign In button. */
    public static final By SIGN_IN_BUTTON =
            By.id("button-sign-in");

    /**
     * Toast / alert displayed after failed login.
     * Used for negative login validation.
     */
    public static final By TOAST_ALERT =
            By.cssSelector("[role='alert']");

}
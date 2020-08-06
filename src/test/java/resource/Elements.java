package resource;

import org.openqa.selenium.By;

public class Elements {

    //Login Elements

    public final static By email = By.cssSelector("#root > div > div > div.login-side > div > form > div:nth-child(2) > input[type=text]");
    public final static By password = By.cssSelector("#root > div > div > div.login-side > div > form > div:nth-child(3) > input[type=password]");
    public final static By loginButton = By.cssSelector("#root > div > div > div.login-side > div > form > div.actions-container > button");
    public final static By forgotPassword = By.cssSelector("#root > div > div > div.login-side > div > form > div.actions-container > p");
    public final static By errorCredentials = By.cssSelector("#error");
    public final static By errorMessageInvalid = By.cssSelector("#root > div > div > div.login-side > div > form > div.error > span");

    public static String invalidCredentials = "Invalid credentials";
    public static String required = "Required";
    public static String invalidEmail = "Invalid email address";
    public static String invalidPassword = "This password is too short(minimum 8 characters)";

    //Forgot Password Elements

    public final static By returnToLogin = By.className("return");
    public final static By resetPassword = By.cssSelector("#root > div > div > form > div.actions > button:nth-child(1)");
    public final static By emailError = By.id("error");
    public final static By enterEmailToResetPass = By.cssSelector("#root > div > div > form > div.input-container > input");
    public final static By alertMessage = By.className("MuiAlert-message");

    public static String emailErrorMessage = "Enter your email address";
    public static String validEmailMessage = "Email sent";
    public static String invalidEmailMessage = "Invalid email address";

}

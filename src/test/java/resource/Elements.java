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

    //Classes Page Elements

    public final static By createButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.title-container > div > button");

    //Create Class Elements
    public final static By createImg = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.image-container.col-2 > img");
    public final static By sendImg = By.className("dropzone");
    public final static By classType = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(1) > div > div > div.css-1hwfws3 > div.css-1wa3eu0-placeholder");
    public final static By classTypeMenu = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(1) > div > input[type=hidden]");
    public final static By virtualOption = By.className("css-1n7v3ny-option");
    //#react-select-5-option-0
    public final static By normalOption = By.className("css-yt9ioa-option");
    //#react-select-5-option-1
    public final static By className = By.cssSelector("input[name=name]");
    public final static By classLocation = By.className("css-1wa3eu0-placeholder");
   // public final static By locationMenu = By.className("css-26l3qy-menu");
    public final static By locationOption = By.cssSelector("#react-select-4-option-4");
    public final static By openRegistration = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(5) > div > input[type=number]");
    public final static By closeRegistration = By.cssSelector("input[name=closeForAttendees]");
    public final static By classParticipants = By.cssSelector("input[name=participants]");
    public final static By classDuration = By.cssSelector("input[name=duration]");
    public final static By prevMonth = By.className("prev-month");
    public final static By nextMonth = By.className("next-month");
    public final static By dayOfClass = By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div/div[10]/div/div[2]/div[2]/div/div[1]/table/tbody/tr[4]/td[5]");
    public final static By currentDate = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(10) > div > div:nth-child(1) > input[type=text]");
    public final static By classDescription = By.cssSelector("textarea[name=description]");
    public final static By classTime = By.cssSelector("input[role=spinbutton]");


}

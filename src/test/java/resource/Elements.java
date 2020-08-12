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
    public final static By addImage = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.image-container.col-2 > img");
    public final static By classType = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(1) > div > div > div.css-1hwfws3 > div.css-1wa3eu0-placeholder");
    public final static By virtualOption = By.className("css-1n7v3ny-option");
    //#react-select-5-option-0
    public final static By normalOption = By.className("css-yt9ioa-option");
    //#react-select-5-option-1
    public final static By className = By.cssSelector("input[name=name]");
    public final static By classLocation = By.className("css-1wa3eu0-placeholder");
    public final static By locationOption = By.cssSelector("#react-select-4-option-4");
    public final static By locationOption2 = By.cssSelector("#react-select-4-option-5");
    public final static By locationName = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(4) > div > div > div.css-1hwfws3 > div.css-1uccc91-singleValue");
    public final static By openRegistration = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(5) > div > input[type=number]");
    public final static By closeRegistration = By.cssSelector("input[name=closeForAttendees]");
    public final static By classParticipants = By.cssSelector("input[name=participants]");
    public final static By classDuration = By.cssSelector("input[name=duration]");

    public final static By currentDate = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(10) > div > div:nth-child(1) > input[type=text]");
    public final static By tableOfDates = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(10) > div > div.datetime-picker.datetime-picker-popup > div:nth-child(2) > div > div.calendar-days > table");
    public final static By calendar = By.tagName("tbody");
    public final static By calendarLines = By.tagName("tr");
    public final static By daysOfWeek = By.tagName("td");
    public final static By classDescription = By.cssSelector("textarea[name=description]");
    public final static By classTime = By.cssSelector("input[role=spinbutton]");
    public final static By submitButton = By.cssSelector("button[type=submit]");

    //View, Edit, Delete class buttons
    public final static By classTable = By.className("rt-tbody");
    public final static By tableElements = By.className("rt-tr-group");
    public final static By rowElements = By.className("rt-td");
    public final static By actionButtons = By.className("button-icon");
    public final static By confirmButton = By.cssSelector("button[type=submit]");
    public final static By closeView = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-header > div.modal-buttons > button > i");

    //Edit Window
    public final static By editClassImage = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.image-container.col-2");
    public final static By editClassLocation = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div > div:nth-child(4) > div > div > div.css-1wy0on6");

    //Schedule Page Elements
    public final static By selectScheduledClass = By.cssSelector("div[title=Test15]");

    public final static By scheduleClassType = By.className("css-107lb6w-singleValue");
    public final static By scheduleClassName = By.cssSelector("input[name=name]");
    public final static By scheduleClassLocation = By.className("css-107lb6w-singleValue");
    public final static By scheduleClassDate = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > input[type=text]");
    public final static By scheduleClassParticipants = By.cssSelector("#number-of-participants > p");
    public final static By scheduleClassOpenRegistration = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(3) > div:nth-child(2) > div > p");
    public final static By scheduleClassCloseRegistration = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(3) > div:nth-child(3) > div > p");
    public final static By scheduleClassDescription = By.className(".scrollbar");
    public final static By startClassTime = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(3) > div > time:nth-child(1)");
    public final static By finishClassTime = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(3) > div > time:nth-child(2)");


    //Trainer Profile Page Elements
    public final static By trainerImage = By.className("image-container");
    public final static By trainerFirstName = By.cssSelector("input[name=firstName]");
    public final static By trainerLastName = By.cssSelector("input[name=lastName]");
    public final static By trainerPhoneNo = By.cssSelector("input[name=phoneNumber]");
    public final static By trainerCountry = By.cssSelector("input[name=country]");
    public final static By trainerCounty = By.cssSelector("input[name=county");
    public final static By trainerCity = By.cssSelector("input[name=city");
    public final static By trainerStreetName = By.cssSelector("input[name=streetName]");
    public final static By trainerStreetNo = By.cssSelector("input[name=streetNumber]");
    public final static By trainerDescription = By.className(".scrollbar");
    public final static By trainerAccreditation = By.cssSelector("input[name=accreditation]");
    public final static By addAccreditation = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.trainer-data-container > div.personal-data > form > div.row.info > div:nth-child(2) > div.accreditation-input > button > i");
    public final static By updateTrainerProfile = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.trainer-data-container > div.personal-data > form > div.row.info > div.actions-container > button");

    public final static By currentPassword = By.cssSelector("input[name=currentPassword]");
    public final static By newPassword = By.cssSelector("input[name=newPassword]");
    public final static By confirmNewPassword = By.cssSelector("input[name=confirmNewPassword]");
    public final static By changePassword = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.trainer-data-container > div.other-data > div > div.password > div > button:nth-child(1)");
    public final static By changePasswordConfirm = By.cssSelector("body > div.ReactModalPortal > div > div > div.modal-body > form > div.actions > button");

    //Home Page Elements
    public final static By todayClasses = By.className("classCard");
    public final static By todayClassName = By.className("classCard-content-name");
    public final static By todayClassType = By.className("classCard-type");
    public final static By attendButton = By.cssSelector("button[type=button]");

}


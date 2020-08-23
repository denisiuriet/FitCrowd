package resource;

import org.openqa.selenium.By;

public class ClientElements {
    //Gym Verify Page Elements
    public final static By gymCode = By.cssSelector("input[name=gymCode]");
    public final static By submitButton = By.cssSelector("button[type=submit]");
    public static String errorMessage = "Customer not found!";

    //For Both Pages
    public final static By error = By.cssSelector("#error");
    public static String missingCredentialMessage = "Required";
    public final static By invalidError = By.className("error-span");

    //Login Page Elements
    public final static By clientEmail = By.cssSelector("input[name=email]");
    public final static By clientPassword = By.cssSelector("input[name=password]");
    public static String invalidEmail = "Invalid email address";
    public static String invalidPassword = "This password is too short(minimum 8 characters)";
    public static String invalidCredentials = "Invalid credentials";
    public static By forgotPassword = By.cssSelector("#root > div > div > div.login-side > div.login > form > div.actions-container > p");

    //Forgot Password Elements
    public static String missingEmail = "Enter your email address";
    public final static By alert = By.className("MuiAlert-message");
    public static String wrongEmailMessage = "User not found !";
    public static String validEmailMessage = "An email has been sent to your address!";
    public final static By returnToLogin = By.cssSelector("#root > div > div > form > div.actions > button.return > span");

    //Client Profile Elements
    public final static By uploadImage = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.admin-data-container > div.personal-data > div > img");
    public final static By clientFirstName = By.cssSelector("input[name=firstName]");
    public final static By clientLastName = By.cssSelector("input[name=lastName]");
    public final static By clientPhoneNumber = By.cssSelector("input[name=phoneNumber]");
    public final static By clientProfileEmail = By.cssSelector("input[name=email");
    public final static By clientStreetName = By.cssSelector("input[name=streetName]");
    public final static By clientStreetNumber = By.cssSelector("input[name=streetNumber]");
    public final static By clientCity = By.cssSelector("input[name=city]");
    public final static By clientCountry = By.cssSelector("input[name=country]");
    public final static By clientCounty = By.cssSelector("input[name=county]");
    public static String updateAlertMessage = "Your profile was updated successfully!";

    //Appointments Elements
    public final static By appointedClass = By.className("rt-tr-group");
    public final static By appointedClassDetails = By.className("rt-td");

    //Schedule Page Elements
    public final static By dayButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.classes-schedule > div > div.rbc-toolbar > span:nth-child(3) > button:nth-child(3)");
    public final static By date = By.className("rbc-toolbar-label");
    public final static By nextButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.classes-schedule > div > div.rbc-toolbar > span:nth-child(1) > button:nth-child(3)");
    public final static By classesOfDay = By.className("rbc-event-content");
    public final static By noOfParticipants = By.cssSelector("#number-of-participants > p");
    public final static By reservation = By.cssSelector("#reservations > span");
    public static String reservationText = "Reservations end in";
    public final static By closeButton = By.className("button-icon");
    public static String successfulBook = "Congrats! You've succesfully booked a place at ";
    public static String checkAppointmentsMessage = "Check out your appointments.";
    public static String bookButtonText = "Book class";

    public final static By className = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(1) > div:nth-child(1) > input[type=text]");
    public final static By classType = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(1) > div:nth-child(2) > input[type=text]");
    public final static By classStatus = By.cssSelector("input[name=status]");
    public final static By classTrainer = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(1) > div > div > div.css-1hwfws3 > div.css-107lb6w-singleValue");
    public final static By classDate = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > input[type=text]");
    public final static By classStartTime = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(3) > div > time:nth-child(1)");
    public final static By classFinishTime = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(2) > div:nth-child(3) > div > time:nth-child(2)");
    public final static By classLocation = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-body > form > div.row.form-content > div.inputs-side.col-2 > div > div:nth-child(3) > div:nth-child(2) > div > div > div.css-1hwfws3 > div.css-107lb6w-singleValue");
    public final static By classDescription = By.className(".scrollbar");

    //Appointments Page Elements
    public final static By spanTag = By.tagName("span");
    public final static By appClassTime = By.tagName("time");
    public final static By xButton = By.cssSelector("body > div:nth-child(7) > div > div > div.modal-header > div.modal-buttons > button > i");
    public final static By attendButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.bills-table > div > div.rt-table > div.rt-tbody > div:nth-child(2) > div > div:nth-child(6) > div > button.button-action.normal");
    public final static By cancelButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.bills-table > div > div.rt-table > div.rt-tbody > div:nth-child(2) > div > div:nth-child(6) > div > button.button-action.danger");
    public final static By bookButton = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.bills-table > div > div.rt-table > div.rt-tbody > div:nth-child(2) > div > div:nth-child(6) > div > button.button-action.success.btn.btn-primary");
    public final static By infoButton = By.className("button-icon");
    public final static By statusText = By.cssSelector("#root > div > div.container-open > div.dashboard > div > div.bills-table > div > div.rt-table > div.rt-tbody > div:nth-child(2) > div > div:nth-child(5) > span");
}

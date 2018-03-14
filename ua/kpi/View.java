package ua.kpi;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installations
    private static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));        // Ukrainian
                    new Locale("en"));  // English


    // Text constants
    public static String INPUT_SURNAME = "input.surname";
    public static String INPUT_NAME = "input.name";
    public static String INPUT_MIDDLENAME = "input.middlename";
    public static String INPUT_NICKNAME = "input.nickname";
    public static String INPUT_GROUP = "input.group";
    public static String INPUT_TELEPHONE_NUMBER = "input.telephone.number";
    public static String INPUT_MOB_NUMBER_PRIMARY = "input.mob.number.primary";
    public static String INPUT_MOB_NUMBER_SECONDARY = "input.mob.number.secondary";
    public static String INPUT_EMAIL = "input.email";
    public static String INPUT_SKYPE = "input.skype";
    public static String INPUT_ZIP_CODE = "input.zip.code";
    public static String INPUT_CITY = "input.city";
    public static String INPUT_STREET = "input.street";
    public static String INPUT_HOUSE_NUMBER = "input.house.number";
    public static String INPUT_APARTMENT_NUMBER = "input.apartment.number";
    public static String WRONG_INPUT_STRING = "input.wrong.string";
    public static String WRONG_INPUT_NUMBER = "input.wrong.number";
    public static String WRONG_INPUT_GROUP = "input.wrong.group";
    public static String WRONG_INPUT_PHONE_NUMBER = "input.wrong.phone.number";


    public void printMessage(String... messages){
        StringBuilder concatString = new StringBuilder();
        for (String v : messages) {
            concatString = concatString.append(bundle.getString(v));
        }
        String message = new String(concatString);
        System.out.println(message);
    }

}

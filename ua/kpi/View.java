package ua.kpi;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installations
    private static String MESSAGES_BUNDLE_NAME = "messages";
    private static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));        // Ukrainian
                    new Locale("en"));  // English


    public void printMessage(String... messages){
        StringBuilder concatString = new StringBuilder();
        for (String v : messages) {
            concatString = concatString.append(bundle.getString(v));
        }
        String message = new String(concatString);
        System.out.println(message);
    }

}

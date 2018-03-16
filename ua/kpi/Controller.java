package ua.kpi;

import ua.kpi.Model.Address;
import ua.kpi.Model.GroupAffiliation;
import ua.kpi.Model.Record;
import ua.kpi.Model.Subscriber;
import ua.kpi.InputMessages;

import java.util.Scanner;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Record record;
    private View view;

    // regex
    private String regexString = "[A-Za-z]{1,15}";
    //private String regexTelephoneNumber = "\\d-\\d{2}-\\d{2}";
    private String regexTelephoneNumber = "\\d{3}-\\d{2}-\\d{2}"; // TODO: check later
    private String regexMobNumber = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$"; // TODO: can make concat with regexTelephoneNumber
    private String regexEmail = "^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
    private String regexNumber = "[0-9]+";
    private String regexAddressHouseNumber = "[0-9]+([A-Z])?";

    public Controller(View view) {
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);

        Subscriber sub = new Subscriber();

        sub.setSurname(inputString(sc, regexString, InputMessages.INPUT_SURNAME, InputMessages.WRONG_INPUT_STRING));
        sub.setName(inputString(sc, regexString, InputMessages.INPUT_NAME, InputMessages.WRONG_INPUT_STRING));
        sub.setMiddlename(inputString(sc, regexString, InputMessages.INPUT_MIDDLENAME, InputMessages.WRONG_INPUT_STRING));
        sub.setNickname(inputString(sc, regexString, InputMessages.INPUT_NICKNAME, InputMessages.WRONG_INPUT_STRING));
        sub.setGroup(inputGroupAffiliation(sc));
        sub.setTelephoneNumber(inputString(sc, regexTelephoneNumber, InputMessages.INPUT_TELEPHONE_NUMBER, InputMessages.WRONG_INPUT_PHONE_NUMBER));
        sub.setMobNumberPrimary(inputString(sc, regexMobNumber, InputMessages.INPUT_MOB_NUMBER_PRIMARY, InputMessages.WRONG_INPUT_PHONE_NUMBER));
        sub.setMobNumberSecondary(inputString(sc, regexMobNumber, InputMessages.INPUT_MOB_NUMBER_SECONDARY, InputMessages.WRONG_INPUT_PHONE_NUMBER));
        sub.setEmail(inputString(sc, regexEmail, InputMessages.INPUT_EMAIL, InputMessages.WRONG_INPUT_STRING));
        sub.setSkype(inputString(sc, regexString, InputMessages.INPUT_SKYPE, InputMessages.WRONG_INPUT_STRING));
        sub.setAddress(inputAddress(sc));

        this.record = new Record(sub, new Date(), new Date());

        System.out.println(record.toString());
    }


    private GroupAffiliation inputGroupAffiliation(Scanner sc) {
        view.printMessage(InputMessages.INPUT_GROUP);
        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    return GroupAffiliation.LOW;
                case 2:
                    return GroupAffiliation.INTERMEDIATE;
                case 3:
                    return GroupAffiliation.HIGH;
                case 4:
                    return GroupAffiliation.ADVANCED;
            }
            view.printMessage(InputMessages.WRONG_INPUT_GROUP);
        }
    }

    private String inputString(Scanner sc, String regex, String inputString, String wrongInputString) {
        view.printMessage(inputString);
        String entry = sc.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(entry);

        while (!matcher.matches()) {
            view.printMessage(wrongInputString);
            view.printMessage(inputString);
            entry = sc.nextLine();
            matcher = pattern.matcher(entry);
        }
        return entry;
    }

    private Address inputAddress(Scanner sc) {
        String zipCode = inputString(sc, regexNumber, InputMessages.INPUT_ZIP_CODE, InputMessages.WRONG_INPUT_NUMBER);
        String cityOfResidence = inputString(sc, regexString, InputMessages.INPUT_CITY, InputMessages.WRONG_INPUT_STRING);
        String street = inputString(sc, regexString, InputMessages.INPUT_STREET, InputMessages.WRONG_INPUT_STRING);
        String houseNumber = inputString(sc, regexAddressHouseNumber, InputMessages.INPUT_HOUSE_NUMBER, InputMessages.WRONG_INPUT_NUMBER);
        String apartmentNumber = inputString(sc, regexNumber, InputMessages.INPUT_APARTMENT_NUMBER, InputMessages.WRONG_INPUT_NUMBER);

        return new Address(zipCode, cityOfResidence, street, houseNumber, apartmentNumber);
    }
}

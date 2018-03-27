package ua.kpi.controller;

import ua.kpi.InputMessages;
import ua.kpi.View;
import ua.kpi.model.*;

import java.util.Scanner;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.kpi.controller.RegexContainer.*;

public class Controller {
    private BookOfRecords bookOfRecords;
    private Record record;
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);

//        Subscriber sub1 = new Subscriber();
//        sub.setSurname(inputString(sc, regexString, InputMessages.INPUT_SURNAME, InputMessages.WRONG_INPUT_STRING));
//        sub.setName(inputString(sc, regexString, InputMessages.INPUT_NAME, InputMessages.WRONG_INPUT_STRING));
//        sub.setMiddlename(inputString(sc, regexString, InputMessages.INPUT_MIDDLENAME, InputMessages.WRONG_INPUT_STRING));
//        sub.setNickname(inputString(sc, regexString, InputMessages.INPUT_NICKNAME, InputMessages.WRONG_INPUT_STRING));
//        sub.setGroup(inputGroupAffiliation(sc));
//        sub.setTelephoneNumber(inputString(sc, regexTelephoneNumber, InputMessages.INPUT_TELEPHONE_NUMBER, InputMessages.WRONG_INPUT_PHONE_NUMBER));
//        sub.setMobNumberPrimary(inputString(sc, regexMobNumber, InputMessages.INPUT_MOB_NUMBER_PRIMARY, InputMessages.WRONG_INPUT_PHONE_NUMBER));
//        sub.setMobNumberSecondary(inputString(sc, regexMobNumber, InputMessages.INPUT_MOB_NUMBER_SECONDARY, InputMessages.WRONG_INPUT_PHONE_NUMBER));
//        sub.setEmail(inputString(sc, regexEmail, InputMessages.INPUT_EMAIL, InputMessages.WRONG_INPUT_STRING));
//        sub.setSkype(inputString(sc, regexString, InputMessages.INPUT_SKYPE, InputMessages.WRONG_INPUT_STRING));
//        sub.setAddress(inputAddress(sc));

        Subscriber sub2 = new Subscriber();
        sub2.setSurname("stets");
        sub2.setName("dan");
        sub2.setMiddlename("olego");
        sub2.setNickname("bruh");
        sub2.setGroup(GroupAffiliation.INTERMEDIATE);
        sub2.setTelephoneNumber("467-25-06");
        sub2.setMobNumberPrimary("467-333-25-06");
        sub2.setMobNumberSecondary("098-330-88-47");
        sub2.setEmail("denyast@ukr.net");
        sub2.setSkype("denyas");
        sub2.setAddress(new Address("04086", "Kyiv", "Olzhycha", "12", "2"));

        Subscriber sub3 = new Subscriber();
        sub3.setSurname("stetsest");
        sub3.setName("danests");
        sub3.setMiddlename("olegoset");
        sub3.setNickname("bruhsdf");
        sub3.setGroup(GroupAffiliation.INTERMEDIATE);
        sub3.setTelephoneNumber("467-25-06");
        sub3.setMobNumberPrimary("467-333-25-06");
        sub3.setMobNumberSecondary("098-330-88-47");
        sub3.setEmail("denyast@ukr.net");
        sub3.setSkype("denyas");
        sub3.setAddress(new Address("04086", "Kyiv", "Olzhycha", "12", "2"));

        BookOfRecords bookOfRecords = new BookOfRecords();

        bookOfRecords.addRecord(sub2, new Date(), new Date());
        bookOfRecords.addRecord(sub3, new Date(), new Date());

        System.out.println(bookOfRecords.toString());
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

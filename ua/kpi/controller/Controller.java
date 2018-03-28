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
    private View view;

    public Controller(View view) {
        this.view = view;
        this.bookOfRecords = new BookOfRecords();
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);


        /* temporary subs - for testing purposes */
        Subscriber sub1 = new Subscriber();

        sub1.setSurname("Stetsenko");
        sub1.setName("Dan");
        sub1.setMiddlename("Olegovych");
        sub1.setNickname("bruh");
        sub1.setGroup(GroupAffiliation.INTERMEDIATE);
        sub1.setTelephoneNumber("462-11-06");
        sub1.setMobNumberPrimary("097-324-25-06");
        sub1.setMobNumberSecondary("098-335-82-47");
        sub1.setEmail("denyast@ukr.net");
        sub1.setSkype("denyast");
        sub1.setAddress(new Address("04086", "Kyiv", "Olzhycha", "8", "18"));
        Record rec1 = new Record(sub1, new Date(), new Date());

        bookOfRecords.tryAddRecord(rec1);


        Subscriber sub2 = new Subscriber("stetsest", "danests", "olegoset", "bruh", GroupAffiliation.LOW,
                "467-25-06", "467-333-25-06", "098-330-88-47", "denyast@ukr.net", "denyas",
                new Address("04086", "Kyiv", "Olzhycha", "12", "2"));
        Record rec2 = new Record(sub2, new Date(), new Date());

        while (!bookOfRecords.tryAddRecord(rec2)) {
            sub2.setNickname(inputString(sc, regexString, InputMessages.INPUT_NICKNAME, InputMessages.WRONG_INPUT_STRING));
        }


        //Subscriber sub = inputSingleSubscriber(sc);
        //Record rec = new Record(sub, new Date(), new Date());
        //bookOfRecords.tryAddRecord(rec);



        bookOfRecords.display();
    }


    private Subscriber inputSingleSubscriber(Scanner sc) {
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

        return sub;
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

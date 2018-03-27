package ua.kpi.controller;

public interface RegexContainer {
    String regexString = "[A-Za-z]{1,15}";
    //String regexTelephoneNumber = "\\d-\\d{2}-\\d{2}";
    String regexTelephoneNumber = "\\d{3}-\\d{2}-\\d{2}"; // TODO: check later
    String regexMobNumber = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$"; // TODO: can make concat with regexTelephoneNumber
    String regexEmail = "^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
    String regexNumber = "[0-9]+";
    String regexAddressHouseNumber = "[0-9]+([A-Z])?";
}

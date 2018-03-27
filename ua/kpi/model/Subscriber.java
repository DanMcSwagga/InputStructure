package ua.kpi.model;

public class Subscriber {
    private String surname;
    private String name;
    private String middlename;
    private String nickname;
    private GroupAffiliation group;
    private String telephoneNumber;
    private String mobNumberPrimary;
    private String mobNumberSecondary;
    private String email;
    private String skype;
    private Address address;

    // Text constants
    private String GROUP_LOW = "Low";
    private String GROUP_INTERMEDIATE = "Intermediate";
    private String GROUP_HIGH = "High";
    private String GROUP_ADVANCED = "Advanced";
    private String GROUP_DEFAULT = "Default";

    public Subscriber() {
        name = "";
        surname = "";
        middlename = "";
        nickname = "";
        group = null;
        telephoneNumber = "";
        mobNumberPrimary = "";
        mobNumberSecondary = "";
        email = "";
        skype = "";
        address = null;
    }

    public Subscriber(String name, String surname, String middlename, String nickname, GroupAffiliation group, String telephoneNumber,
               String mobNumberPrimary, String mobNumberSecondary, String email, String skype, Address address) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.nickname = nickname;
        this.group = group;
        this.telephoneNumber = telephoneNumber;
        this.mobNumberPrimary = mobNumberPrimary;
        this.mobNumberSecondary = mobNumberSecondary;
        this.email = email;
        this.skype = skype;
        this.address = address;
    }

    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getMiddlename() { return middlename; }
    public String getNickname() { return nickname; }
    public GroupAffiliation getGroup() { return group; }
    public String getTelephoneNumber() { return telephoneNumber; }
    public String getMobNumberPrimary() { return mobNumberPrimary; }
    public String getMobNumberSecondary() { return mobNumberSecondary; }
    public String getEmail() { return email; }
    public String getSkype() { return skype; }
    public Address getAddress() { return address; }

    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setMiddlename(String middlename) { this.middlename = middlename; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setGroup(GroupAffiliation group) { this.group = group; }
    public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
    public void setMobNumberPrimary(String mobNumberPrimary) { this.mobNumberPrimary = mobNumberPrimary; }
    public void setMobNumberSecondary(String mobNumberSecondary) { this.mobNumberSecondary = mobNumberSecondary; }
    public void setEmail(String email) { this.email = email; }
    public void setSkype(String skype) { this.skype = skype; }
    public void setAddress(Address address) { this.address = address; }

    private String toStringGroup() {
        switch (group) {
            case LOW:
                return GROUP_LOW;
            case INTERMEDIATE:
                return GROUP_INTERMEDIATE;
            case HIGH:
                return GROUP_HIGH;
            case ADVANCED:
                return GROUP_ADVANCED;
        }
        return GROUP_DEFAULT;
    }

    @Override
    public String toString() {
        return "Full name: " + name + ' ' + middlename + ' ' + surname + ';' +
                "\nNickname: " + nickname + ";\nGroup: " + toStringGroup() + ';' +
                "\nTelephone: " + telephoneNumber + ';' +
                "\nMobile phone #1: " + mobNumberPrimary + ", Mobile phone #2: " + mobNumberSecondary + ';' +
                "\nEmail: " + email + ", Skype: " + skype + ';' + address;
    }
}

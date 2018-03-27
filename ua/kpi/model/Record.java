package ua.kpi.model;

import java.util.Date;

public class Record {
    private Subscriber sub;
    private Date dateOfCreation;
    private Date dateOfLastChange;

    public Record(Subscriber sub, Date dateOfCreation, Date dateOfLastChange) {
        this.sub = sub;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastChange = dateOfLastChange;
    }

    public Subscriber getSubscriber() { return sub; }
    public Date getDateOfCreation() { return dateOfCreation; }
    public Date getDateOfLastChange() { return dateOfLastChange; }


    @Override
    public String toString() {
        return "Date of creation: " + dateOfCreation.toString() + ';' +
                "\nDate of last change: " + dateOfLastChange.toString() + ';' +
                "\n\n\tSUBSCRIBER\n" + sub.toString();
    }
}

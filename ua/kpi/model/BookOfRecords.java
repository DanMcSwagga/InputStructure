package ua.kpi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BookOfRecords {
    private ArrayList<Record> bookOfRecords;

    public BookOfRecords() {
        this.bookOfRecords = new ArrayList<Record>();
    }

    public List<Record> getBookOfRecords() { return bookOfRecords; }

    public void addRecord(Subscriber sub, Date dateOfCreation, Date dateOfLastChange) {
        this.bookOfRecords.add(new Record(sub, dateOfCreation, dateOfLastChange));
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder concatString = new StringBuilder();
        int count = 0;
        for (Record record : bookOfRecords) {
            concatString = concatString.append("\n\n#" + ++count + "\n");
            concatString = concatString.append(record.toString());
        }
        return new String(concatString);
    }
}

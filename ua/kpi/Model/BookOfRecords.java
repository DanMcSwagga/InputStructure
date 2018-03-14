package ua.kpi.Model;

import java.util.Date;
import java.util.List;

public class BookOfRecords {
    private List<Record> bookOfRecords;

    public BookOfRecords(List<Record> bookOfRecords) {
        this.bookOfRecords = bookOfRecords;
    }

    public List<Record> getBookOfRecords() { return bookOfRecords; }

    public void addRecord(Subscriber sub, Date dateOfCreation, Date dateOfLastChange) {
        this.bookOfRecords.add(new Record(sub, dateOfCreation, dateOfLastChange));
    }
}

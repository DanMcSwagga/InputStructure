package ua.kpi.model;

import ua.kpi.exceptions.DataException;

import java.util.ArrayList;
import java.util.List;


public class BookOfRecords {
    private ArrayList<Record> bookOfRecords;

    public BookOfRecords() {
        this.bookOfRecords = new ArrayList<>(); // same as <Record>
    }

    public List<Record> getBookOfRecords() { return bookOfRecords; }

    private void addRecord(Record record) throws DataException {
        if (record == null) {
            throw new NullPointerException("NullPtrException");
        }

        for (Record savedRecord : bookOfRecords) {
            if (record.getSubscriber().getNickname().equals(savedRecord.getSubscriber().getNickname())) {
                throw new DataException(record);
            }
        }

        this.bookOfRecords.add(record);
    }

    public boolean addRecordCheck(Record record) {
        try {
            addRecord(record);
            return true;
        } catch (NullPointerException e) { // Undecided if needed
            System.err.print(e.getMessage());
            return false;
        } catch (DataException e) {
            System.err.print(e.getErrorMessage());
            return false;
        }
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder concatString = new StringBuilder();
        int count = 0;
        for (Record record : bookOfRecords) {
            concatString = concatString.append("\n\n#").append(++count).append("\n");
            concatString = concatString.append(record.toString());
        }
        return new String(concatString);
    }
}

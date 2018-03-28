package ua.kpi.exceptions;

import ua.kpi.model.Record;

public class DataException extends Exception {
    private Record wrongRecord;

    public DataException(Record record) {
        this.wrongRecord = record;
    }

    public Record getWrongBook() {
        return wrongRecord;
    }

    public String getErrorMessage() {
        return "The nickname \'" + this.wrongRecord.getSubscriber().getNickname() +
                "\' is already taken. Please, choose another available nickname.\n";
    }


    @Override
    public String toString() {
        return "DataException -- " + '\n' + wrongRecord.toString() + '\n';
    }
}

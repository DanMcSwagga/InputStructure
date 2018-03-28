package ua.kpi.exceptions;

public class DataException extends Exception {
    private String message;

    public DataException() {
        this.message = null;
    }

    public DataException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DataException -- " + '\'' + message +'\'';
    }
}

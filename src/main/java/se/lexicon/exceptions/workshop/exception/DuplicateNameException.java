package se.lexicon.exceptions.workshop.exception;


public class DuplicateNameException extends RuntimeException {
    private String duplicateName;


    public DuplicateNameException(String message, String duplicateName) {
        super(message);
        this.duplicateName = duplicateName;
    }

    public String getDuplicateName(){
        return duplicateName;
    }

    @Override public String toString(){
        return "Message: " + super.getMessage() + ", Duplicate Name: " + getDuplicateName();
    }
}

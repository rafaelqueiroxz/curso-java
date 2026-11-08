package model.exceptios;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}

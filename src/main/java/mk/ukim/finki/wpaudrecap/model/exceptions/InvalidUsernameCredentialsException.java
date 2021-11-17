package mk.ukim.finki.wpaudrecap.model.exceptions;

public class InvalidUsernameCredentialsException extends RuntimeException{

    public InvalidUsernameCredentialsException() {
        super("Invalid user credentials!");
    }
}

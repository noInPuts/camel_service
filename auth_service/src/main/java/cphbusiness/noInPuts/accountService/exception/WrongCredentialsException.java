package cphbusiness.noInPuts.accountService.exception;

public class WrongCredentialsException extends Exception {
    public WrongCredentialsException(String errorMessage) {
        super(errorMessage);
    }
}

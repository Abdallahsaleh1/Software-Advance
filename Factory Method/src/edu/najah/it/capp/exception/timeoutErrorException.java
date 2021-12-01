package edu.najah.it.capp.exception;

public class timeoutErrorException extends ProtocolException {

	public timeoutErrorException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "Failed to send the data because of a timeout error. " + message;
		
	}
}

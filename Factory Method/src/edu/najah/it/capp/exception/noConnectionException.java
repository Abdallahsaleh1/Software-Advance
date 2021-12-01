package edu.najah.it.capp.exception;

public class noConnectionException extends ProtocolException {
	public noConnectionException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "No connection is available " + message;
		
	}
}

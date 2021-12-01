package edu.najah.it.capp.exception;

public class inUseException extends ProtocolException {
	public inUseException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "Connection is inuse, you can’t release now " + message;
		
	}
}

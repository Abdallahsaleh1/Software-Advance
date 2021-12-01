package edu.najah.it.capp.exception;

public class alreadyReleasedException extends ProtocolException {
	
	public alreadyReleasedException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "Connection is already in released " + message;
		
	}

}

package edu.najah.it.capp.exception;

public class unknownErrorException extends ProtocolException {
	public unknownErrorException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "Unable to release the connection because of an unknown error " + message;
		
	}
}

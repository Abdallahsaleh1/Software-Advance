package edu.najah.it.capp.exception;

public class busySystemException extends ProtocolException {
	
	public busySystemException(String message) {
        super(message);
    }
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return "System is too busy now " + message;
		
	}
}

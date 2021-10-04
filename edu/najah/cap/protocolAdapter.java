package edu.najah.cap;

public class protocolAdapter implements newProtocol {
	
	protocols protocol;
	
	public protocolAdapter(	protocols protocol) {
		this.protocol = protocol;
	}
	
	public  boolean remove(String connectionProtocol) {
		
		return protocol.release(connectionProtocol);

	}
	
	public void sendMessage(String message) {
		protocol.send(message);
	}

}

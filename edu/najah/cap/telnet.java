package edu.najah.cap;

public class telnet implements protocols{
	private static telnet TELNET = null;
	
	private telnet() {
		Connection.connectionCounts++;
	}
	public static telnet getInstance(String connectionProtocol){
			if(telnet.TELNET == null) {
				if(Connection.connectionCounts < 3) {
					telnet.TELNET = new telnet();
					
					for(int i=0;i<Connection.connectionCounts;i++) {
						if(Connection.currentConnections[i]=="") {
							Connection.currentConnections[i]=connectionProtocol;
						}
					}
					
				}
				else {
					System.out.println("you have exceed the maximum amount of connections");
				}
				
			}
			else {
				System.out.println("the connection has already been made before");
				 
			}
			
			return TELNET;
	
	}
	
	public  boolean release(String connectionProtocol) {
		if(telnet.TELNET == null) {
			System.out.println("there's no telnet connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			telnet.TELNET = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the telnet connection has been released");
			return true;	 
		}
	}
	
	public void send(String message) {
		System.out.println("Sending" +" "+message+" "+"via telnet protocol");
	}
}

package edu.najah.cap;

public class tftp implements newProtocol{
private static tftp TFTP = null;
	
	private tftp() {
		Connection.connectionCounts++;
	}
	public static tftp getInstance(String connectionProtocol){
			if(tftp.TFTP == null) {
				if(Connection.connectionCounts < 3) {
					tftp.TFTP = new tftp();
					
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
			
			return TFTP;
	
	}
	
	public  boolean remove(String connectionProtocol) {
		if(tftp.TFTP == null) {
			System.out.println("there's no TFTP connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			tftp.TFTP = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the tftp connection has been released");
			return true;	 
		}
	}
	
	public void sendMessage(String message) {
		System.out.println("Sending" +" "+message+" "+"via tftp protocol");
	}
}

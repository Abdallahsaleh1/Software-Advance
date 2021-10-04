package edu.najah.cap;

public class scp implements protocols{
	private static scp SCP = null;
	
	private scp() {
		Connection.connectionCounts++;
	}
	public static scp getInstance(String connectionProtocol){
			if(scp.SCP == null) {
				if(Connection.connectionCounts < 3) {
					scp.SCP = new scp();
					
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
			
			return SCP;
	
	}
	
	public  boolean release(String connectionProtocol) {
		if(scp.SCP == null) {
			System.out.println("there's no scp connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			scp.SCP = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the scp connection has been released");
			return true;	 
		}
	}
	
	public void send(String message) {
		System.out.println("Sending" +" "+message+" "+"via scp protocol");
	}
}

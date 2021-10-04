package edu.najah.cap;

public class ssh implements protocols{
	private static ssh SSH = null;
	
	private ssh() {
		Connection.connectionCounts++;
	}
	public static ssh getInstance(String connectionProtocol){
			if(ssh.SSH == null) {
				if(Connection.connectionCounts < 3) {
					ssh.SSH = new ssh();
					
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
			
			return SSH;
	
	
	}
	
	public  boolean release(String connectionProtocol) {
		if(ssh.SSH == null) {
			System.out.println("there's no ssh connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			ssh.SSH = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the ssh connection has been released");
			return true;	 
		}
	}
	
	public void send(String message) {
		System.out.println("Sending" +" "+message+" "+"via ssh protocol");
	}
}

package edu.najah.cap;

public class ftp implements protocols{
	private static ftp FTP = null;
	
	private ftp() {
		Connection.connectionCounts++;
	}
	public static ftp getInstance(String connectionProtocol){
			if(ftp.FTP == null) {
				if(Connection.connectionCounts < 3) {
					ftp.FTP = new ftp();
					
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
			
			return FTP;
	}
	
	public  boolean release(String connectionProtocol) {
		if(ftp.FTP == null) {
			System.out.println("there's no ftp connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			ftp.FTP = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the ftp connection has been released");
			return true;	 
		}
	}
	
	public void send(String message) {
		System.out.println("Sending" +" "+message+" "+"via ftp protocol");
	}
}

package edu.najah.cap;

public class http implements protocols{
	private static http HTTP = null;
	
	private http() {
		Connection.connectionCounts++;
	}
	public static http getInstance(String connectionProtocol){
			if(http.HTTP == null) {
				if(Connection.connectionCounts < 3) {
					http.HTTP = new http();
					
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
			
			return HTTP;
	
	}
	
	public  boolean release(String connectionProtocol) {
		if(http.HTTP == null) {
			System.out.println("there's no http connection to release");
			return false;
		}
		else {
			Connection.connectionCounts--;
			http.HTTP = null;
			
			for (int i=0;i<Connection.connectionCounts;i++) {
				if(Connection.currentConnections[i]== connectionProtocol) {
					Connection.currentConnections[i]="";
					
				}
			}
			
			System.out.println("the http connection has been released");
			return true;	 
		}
	}
	
	public void send(String message) {
		System.out.println("Sending" +" "+message+" "+"via http protocol");
	}
}

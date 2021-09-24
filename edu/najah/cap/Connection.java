package edu.najah.cap;

public class Connection {
	private static Connection ssh = null;
	private static Connection telnet = null;
	private static Connection http = null;
	private static Connection scp = null;
	private static Connection ftp = null;
	
	private static int connectionCounts=0;
	public static final String SSH = "ssh";
	public static final String TelNet = "telnet";
	public static final String Http = "http";
	public static final String Scp = "scp";
	public static final String Ftp = "ftp";
	private static String[] currentConnections= new String[3];
	private Connection() {
		connectionCounts++;
	}
	
	public static Connection getInstance(String connectionProtocol){
		
		if(connectionProtocol == Connection.SSH) {
			if(Connection.ssh == null) {
				if(connectionCounts < 3) {
					Connection.ssh = new Connection();
					
					for(int i=0;i<connectionCounts;i++) {
						if(currentConnections[i]=="") {
							currentConnections[i]=connectionProtocol;
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
			return Connection.ssh;
		} else if(connectionProtocol == Connection.TelNet) {
				if(Connection.telnet == null) {
					if(connectionCounts < 3) {
						Connection.telnet = new Connection(); 
						
						for(int i=0;i<connectionCounts;i++) {
							if(currentConnections[i]=="") {
								currentConnections[i]=connectionProtocol;
							}
						}
						currentConnections[connectionCounts-1]=connectionProtocol;
					}
					else {
						System.out.println("you have exceed the maximum amount of connections");
					}
					
				}
				else {
					System.out.println("the connection has already been made before");
					 
				}
				return Connection.telnet;
		} else if(connectionProtocol == Connection.Http) {
				if(Connection.http == null) {
					if(connectionCounts < 3) {
						Connection.http = new Connection();
						
						for(int i=0;i<connectionCounts;i++) {
							if(currentConnections[i]=="") {
								currentConnections[i]=connectionProtocol;
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
				return Connection.http;
		} else if(connectionProtocol == Connection.Scp) {
			if(Connection.scp == null) {
				if(connectionCounts < 3) {
					Connection.scp = new Connection(); 
					
					for(int i=0;i<connectionCounts;i++) {
						if(currentConnections[i]=="") {
							currentConnections[i]=connectionProtocol;
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
			return Connection.scp;
		} else if(connectionProtocol == Connection.Ftp) {
			if(Connection.ftp == null) {
				if(connectionCounts < 3) {
					Connection.ftp = new Connection(); 
					
					for(int i=0;i<connectionCounts;i++) {
						if(currentConnections[i]=="") {
							currentConnections[i]=connectionProtocol;
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
			return Connection.ftp;
		}
		
		
		return null;
	}
	
	public static boolean release(String connectionProtocol) {
		if(connectionProtocol == Connection.SSH) {
			if(Connection.ssh == null) {
				System.out.println("there's no ssh connection to release");
				return false;
			}
			else {
				connectionCounts--;
				Connection.ssh = null;
				
				for (int i=0;i<connectionCounts;i++) {
					if(currentConnections[i]== connectionProtocol) {
						currentConnections[i]="";
						
					}
				}
				
				System.out.println("the ssh connection has been released");
				return true;	 
			}
		} else if(connectionProtocol == Connection.TelNet) {
			if(Connection.telnet == null) {
				System.out.println("there's no telnet connection to release");
				return false;
			}
			else {
				connectionCounts--;
				Connection.telnet = null;
				
				for (int i=0;i<connectionCounts;i++) {
					if(currentConnections[i]== connectionProtocol) {
						currentConnections[i]="";
						
					}
				}
				System.out.println("the telnet connection has been released");
				return true;	 
			}
		} else if(connectionProtocol == Connection.Http) {
			if(Connection.http == null) {
				System.out.println("there's no http connection to release");
				return false;
			}
			else {
				connectionCounts--;
				Connection.http = null;
				
				for (int i=0;i<connectionCounts;i++) {
					if(currentConnections[i]== connectionProtocol) {
						currentConnections[i]="";
						
					}
				}
				System.out.println("the http connection has been released");
				return true;	 
			}
		} else if(connectionProtocol == Connection.Scp) {
			if(Connection.scp == null) {
				System.out.println("there's no scp connection to release");
				return false;
			}
			else {
				connectionCounts--;
				Connection.scp = null;
				
				for (int i=0;i<connectionCounts;i++) {
					if(currentConnections[i]== connectionProtocol) {
						currentConnections[i]="";
						
					}
				}
				System.out.println("the scp connection has been released");
				return true;	 
			}
		} else if(connectionProtocol == Connection.Ftp) {
			if(Connection.ftp == null) {
				System.out.println("there's no ftp connection to release");
				return false;
			}
			else {
				connectionCounts--;
				Connection.ftp = null;
				
				for (int i=0;i<connectionCounts;i++) {
					if(currentConnections[i]== connectionProtocol) {
						currentConnections[i]="";
						
					}
				}
				System.out.println("the ftp connection has been released");
				return true;	 
			}
		}
		
		
		return false;
	}
	
	public static String[] getCurrentConnections() {
		return currentConnections;
	}
	
	public void send(String message) {
		if(this==Connection.ssh) {
			System.out.println("Sending" +" "+message+" "+"via"+"SSH"+" "+"protocol");

		} else if(this==Connection.telnet) {
			System.out.println("Sending" +" "+message+" "+"via"+"TELNET"+" "+"protocol");
		} else if(this==Connection.http) {
			System.out.println("Sending" +" "+message+" "+"via"+"HTTP"+" "+"protocol");
		} else if(this==Connection.scp) {
			System.out.println("Sending" +" "+message+" "+"via"+"SCP"+" "+"protocol");
		}else if(this==Connection.ftp) {
			System.out.println("Sending" +" "+message+" "+"via"+"FTP"+" "+"protocol");
		}
		
	}
	
	
	
	
}

package edu.najah.cap;

public class Connection {
	
	public static int connectionCounts=0;
	public static final String SSH = "ssh";
	public static final String TelNet = "telnet";
	public static final String Http = "http";
	public static final String Scp = "scp";
	public static final String Ftp = "ftp";
	public static String[] currentConnections= new String[3];
	private Connection() {
		connectionCounts++;
	}
	
	public static protocols  getInstance(String connectionProtocol){
		if(connectionProtocol.equals(Connection.SSH) ) {
			return ssh.getInstance(connectionProtocol);
		} else if(connectionProtocol.equals(Connection.TelNet)) {
			return telnet.getInstance(connectionProtocol);

		} else if(connectionProtocol.equals(Connection.Http)) {
			return http.getInstance(connectionProtocol);

		} else if(connectionProtocol.equals(Connection.Scp)) {
			return scp.getInstance(connectionProtocol);

		} else if(connectionProtocol.equals(Connection.Ftp)) {
			return ftp.getInstance(connectionProtocol);

		}
		return null;
	}
	
	
	
	public static String[] getCurrentConnections() {
		return currentConnections;
	}
	
	
	
	
	
	
}

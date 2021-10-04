package edu.najah.cap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		protocols telnetcon = Connection.getInstance(Connection.TelNet);
		System.out.println(telnetcon);
		protocols telnetcon2 = Connection.getInstance(Connection.TelNet);
		
		System.out.println(telnetcon2);
		
		boolean isReleased = telnetcon.release(Connection.TelNet);
		protocols httpcon = Connection.getInstance(Connection.Http);
		
		protocols scpCon = Connection.getInstance(Connection.Scp);
		protocols ftpcon = Connection.getInstance(Connection.Ftp);
		protocols telnetcon3 = Connection.getInstance(Connection.TelNet);

		

		ftpcon.send("heelo");
		

	}

}

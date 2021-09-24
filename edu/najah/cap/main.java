package edu.najah.cap;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection telnetcon = Connection.getInstance(Connection.TelNet);
		System.out.println(telnetcon);
		Connection telnetcon2 = Connection.getInstance(Connection.TelNet);
		
		System.out.println(telnetcon2);
		
		boolean isReleased = Connection.release(Connection.TelNet);
		Connection httpcon = Connection.getInstance(Connection.Http);
		
		Connection scpCon = Connection.getInstance(Connection.Scp);
		Connection ftpcon = Connection.getInstance(Connection.Ftp);
		Connection telnetcon3 = Connection.getInstance(Connection.TelNet);

		

		ftpcon.send("heelo");
		

	}

}

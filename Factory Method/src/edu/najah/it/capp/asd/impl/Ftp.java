package edu.najah.it.capp.asd.impl;

import edu.najah.it.capp.asd.constraints.constraints;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.alreadyReleasedException;
import edu.najah.it.capp.exception.busySystemException;
import edu.najah.it.capp.exception.inUseException;
import edu.najah.it.capp.exception.noConnectionException;
import edu.najah.it.capp.exception.timeoutErrorException;
import edu.najah.it.capp.exception.unknownErrorException;
import edu.najah.it.capp.logger.Logger;



public class Ftp implements Protocol {
	
	private static Protocol instance;
	
	
	private Ftp() {
		System.out.println("Creating a new FTP insatnce");
	}
	
	protected static Protocol getInsatnce() {
		if(instance == null) {
			instance = new Ftp();
			Logger.getInstance().logInfo("FTP connection has been created");
		}
		return instance;
	}
	public boolean release() throws ProtocolException{
		int status = constraints.CONNECTION_AVAILABLE;
		
		if(instance == null) {
			throw new alreadyReleasedException("");
		}
		else if(status == constraints.CONNECTION_INUSE) {
			throw new inUseException("");
		} else if(status == constraints.CONNECTION_AVAILABLE){
			instance = null;
			Logger.getInstance().logInfo("FTP connection has been released");
			return true;
		} 
			throw new unknownErrorException("");
		
	}

	public void send(String message) throws ProtocolException {
		int status = constraints.CONNECTION_AVAILABLE;

		if(instance ==null) {
			throw new noConnectionException("");
		} else if(status == constraints.SYSTEM_BUSY) {
			throw new busySystemException("");
		} else if(status == constraints.TIMOUT_ERROR) {
			throw new timeoutErrorException("");
		}
		System.out.println("Sending message from FTP :: " + message);

	}

}

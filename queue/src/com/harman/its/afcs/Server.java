package com.harman.its.afcs;

import java.io.File;

/**\
 * AFCS Server connection and sending the files to server
 */

public class Server {

	File file=null;
	public boolean serverConnection(File fd) {
		int flag = 1; 
		/* Give the AFCS Server connection here */
		// flag=0;
		if(flag == 0) {
			
			return false;
		}
		return true;
	}
}

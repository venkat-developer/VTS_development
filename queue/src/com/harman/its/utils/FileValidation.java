package com.harman.its.utils;
import java.io.File;
/**\
 * 
 * @author HDamodaran
 *
 */
public class FileValidation {

	File file;
	int length;
	String fileName;
	/**\
	 * Validating the file for Naming Conventions
	 * @param fd
	 * @return
	 */
	public boolean fileName(File fd){
		System.out.println("File Validation...");
		file=fd;
		System.out.println("File Name :"+file.getName());
		System.out.println("File Size :"+file.length());
		length=(int) file.length();
		if(length <= 2097153) {
			fileName=file.getName();
			if(!fileName.endsWith(".jpg")) {
				System.out.println("Uploaded file doesnt has the jpg extension");
				return false;
			}
		}
		else {
			System.out.println("File Size exceeds 2MB");
			return false;
		}
		return true;
	}
}

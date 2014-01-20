package org.jpacheco.rest.spring.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

public class FileHelper {
	
	   
	   public static byte[] extractBytesFromStringBase64(String fileString){
		    if(fileString == null)
			   return null;
			String[] fileSplit = StringUtils.split(fileString, ",");
			if(fileSplit.length > 1)
				return Base64.decodeBase64(fileSplit[1]);
			else
				return null;
	   }
	   
	   public static void copyBytesToFile(byte[] fileByte, String path, String filename){
			File file = new File(path + filename);
			try {
				FileUtils.writeByteArrayToFile(file, fileByte);
			} catch (IOException e) {
				e.printStackTrace();
			}		   
		   
	   }

}

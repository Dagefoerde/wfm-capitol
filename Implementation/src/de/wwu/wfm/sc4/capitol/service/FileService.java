package de.wwu.wfm.sc4.capitol.service;

import java.io.File;

public class FileService {
	
	public static boolean doesFolderExist(String path){
		File folderExisting = new File(path);
		return folderExisting.exists();
	}
	
	public static void createFolderIfItDoesNotExist(String path){
		if (!doesFolderExist(path))
			new File(path).mkdir();
	}

}

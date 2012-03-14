package com.SysAdmin;

import android.os.Environment;

/**
 * Provides methods to access common file path variables.
 * 
 * @author Lukas Bernreiter
 * @version 0.3, 14/03/2012
 * @since 0.3
 */
public abstract class FilePathFacade 
{
	private static final String SD = Environment.getExternalStorageDirectory().getAbsolutePath();
	private static final String ROOTDIRECTORY_WORKING = "/SysAdmin/";
	private static final String SUBDIRECTORY_SAVED = "Saved/";			
	private static final String FILE_TEMP = "temp.xml";
	
	public static String GetTempFile(){
		return SD+ROOTDIRECTORY_WORKING+FILE_TEMP;
	}
	
	public static String GetSavedDirectory(){
		return SD+ROOTDIRECTORY_WORKING+SUBDIRECTORY_SAVED;
	}
}

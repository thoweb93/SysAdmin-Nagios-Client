package com.SysAdmin;

/**
 * Provides methods to access to common variables.
 * 
 * @author Lukas Bernreiter
 * @version 0.1, 19/02/2012S
 * @since 0.1
 */
public class AppFacade 
{
	private static final String TAG = "SysAdmin";
	
	
	/** 
	 * Returns the tag used by the application for logging 
	 * @return the tag of this application. 
	 * @see String */
	public static String GetTag(){return TAG;}
}

package com.SysAdmin;

import android.appwidget.AppWidgetManager;

/**
 * Provides methods to access to common variables.
 * 
 * @author Lukas Bernreiter
 * @version 0.2, 19/02/2012S
 * @since 0.1
 */
public class AppFacade 
{
	private static final String TAG = "SysAdmin";	
	private static Integer WidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	
	/** 
	 * Returns the tag used by the application for logging 
	 * @return the tag of this application. 
	 * @see String */
	public static String GetTag(){return TAG;}
	
	/**
	 * Returns the widget id
	 * @return the id of the widget
	 * @see Integer
	 */
	public static Integer GetAppWidgetId(){return WidgetId;}
	
	/**
	 * Sets the id of the widget.
	 * @param _id the new id of the widget
	 * @throws Exception 
	 */
	public static void SetAppWidgetId(Integer _id) throws Exception
	{
		// check if the id is invalid
		if(_id != AppWidgetManager.INVALID_APPWIDGET_ID)
			WidgetId = _id;
		else
			throw new Exception("Id is invalid");
	}
}

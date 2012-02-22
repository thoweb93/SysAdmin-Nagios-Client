package com.SysAdmin;	

import android.appwidget.AppWidgetManager;
import android.os.Environment;

/**
 * Provides methods to access to common variables.
 * 
 * @author Lukas Bernreiter
 * @version 0.2, 22/02/2012S
 * @since 0.1
 */
public class AppFacade 
{
	private static final String TAG 			  = "SysAdmin";	
	private static Integer WidgetId 			  = AppWidgetManager.INVALID_APPWIDGET_ID;
	private static final String XML_START_TAG 	  = "RSS-Widgets";
	private static final String XML_START_WIDGET  = "Widget";
	private static final String XML_ATTRIBUTE_URL = "URL";
	private static final String XML_START_NAME 	  = "Name";
	private static final String XML_START_FILTER  = "Filter";
	private static final String SD 				  = Environment.getExternalStorageState();
	private static final String FILENAME = "Widgets.xml";
	private static final String XML_FILE = SD + "/SysAdmin/" + FILENAME;			
	
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
	
	/**
	 * Retrieves the start tag of the XML file.
	 * @return the start tag.
	 */
	public static String GetXMLStartTag(){return XML_START_TAG;}
	
	/**
	 * Retrieves the start tag of the widget section.
	 * @return the start tag.
	 */
	public static String GetXMLStartWidget(){return XML_START_WIDGET;}
	
	/**
	 * Retrieves the start tag of the widget name section.
	 * @return the start tag.
	 */
	public static String GetXMLStartName(){return XML_START_NAME;}
	
	/**
	 * Retrieves the attribute tag of the widget section.
	 * @return the attribute tag.
	 */
	public static String GetXMLAttributeURL(){return XML_ATTRIBUTE_URL;}
	
	/**
	 * Retrieves the start tag of the filter section.
	 * @return the start tag.
	 */
	public static String GetXMLStartFilter(){return XML_START_FILTER;}

	/**
	 * Retrieves the filename of the XML file.
	 * @return the filename.
	 */
	public static String GetXMLFile(){return XML_FILE; }
	
}

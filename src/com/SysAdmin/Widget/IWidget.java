package com.SysAdmin.Widget;

import java.net.URL;
import java.util.List;

/**
 * @author Lukas Bernreiter
 * @version 0.2, 22/02/2012
 * @since 0.2
 */
public interface IWidget 
{	
	/**
	 * Retrieves the count of filters of a widget.
	 * @return the count of filters.
	 * @see Integer
	 */
	Integer getFilterCount();
	
	/**
	 * Retrieves a list of filters applied to the widget.
	 * @return a list of filters.
	 */
	List<String> getActiveFilter();
	
	/**
	 * Retrieves the name of the widget.
	 * @return the name of the widget
	 * @see String
	 */
	String getWidgetName();
	
	/**
	 * Sets the name of the widget.
	 * @param _name the new name of the widget.
	 */
	void setWidgetName(String _name);
	
	/**
	 * Adds a new filter to the list of the filters.
	 * @param _filter the new filter.
	 */
	void addFilterToList(String _filter);
	
	/**
	 * Retrieves the URL of the RSS server
	 * @return the URL of the RSS server
	 * @see java.net.URL 
	 */
	URL getServerURL();
	
	/**
	 * Sets the URL of the RSS server
	 * @param _url the URL of the RSS server
	 * @see java.net.URL
	 */
	void setServerURL(URL _url);
	
}

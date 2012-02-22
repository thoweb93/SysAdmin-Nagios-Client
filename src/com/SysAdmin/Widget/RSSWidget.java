package com.SysAdmin.Widget;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Lukas Bernreiter
 * @version 0.2, 22/02/2012
 * @since 0.2
 */
public class RSSWidget implements IWidget
{
	private String widgetName = "";
	private URL serverURL = null;
	private List<String> filterList = null;
	
	/**
	 * Default Constructor
	 * @throws MalformedURLException
	 */
	public RSSWidget() throws MalformedURLException{ this("New Widget", new URL(""));	}

	/**
	 * Constructor 
	 * @param _widgetName the name of the widget
	 * @param _serverURL the URL of the RSS server
	 * @see java.lang.String
	 * @see java.net.URL
	 */
	public RSSWidget(String _widgetName, URL _serverURL)
	{
		this.widgetName = _widgetName;
		this.serverURL = _serverURL;
	}
	
	public Integer getFilterCount() 
	{		
		return this.filterList.size();
	}

	public String getWidgetName() 
	{
		return this.widgetName;
	}

	public void setWidgetName(String _name) 
	{
		this.widgetName = _name;
	}

	public void addFilterToList(String _filter) 
	{
		this.filterList.add(_filter);
	}

	public URL getServerURL() 
	{	
		return this.serverURL;
	}

	public void setServerURL(URL _url) 
	{
		this.serverURL = _url;
	}

	public List<String> getActiveFilter() 
	{
		return this.filterList;
	}
	
}

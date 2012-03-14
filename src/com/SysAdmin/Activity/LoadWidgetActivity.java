package com.SysAdmin.Activity;

import java.io.File;

import com.SysAdmin.AppFacade;
import com.SysAdmin.FilePathFacade;
import com.SysAdmin.R;
import com.SysAdmin.EventListener.EventListener_LoadWidget;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;


/**
 * Displays a list of saved files.
 * 
 * @author Lukas Bernreiter
 * @version 0.3, 14/03/2012
 * @since 0.3
 */
public class LoadWidgetActivity extends ListActivity 
{
	private EventListener_LoadWidget mEventListener_LoadWidget = null; 
	
	/** Called when the activity is first created. */
	protected void onCreate(Bundle _icicle)
	{
		super.onCreate(_icicle);
		
		this.initializeObjects();			
		
		ArrayAdapter<String> dataSource = new ArrayAdapter<String>(this, R.layout.list_item, this.getFilenames());
		
		this.setListAdapter(dataSource);
	}
	
	private void initializeObjects()
	{
		this.mEventListener_LoadWidget = new EventListener_LoadWidget(this);
		this.mEventListener_LoadWidget.setEvents();
	}
	
	private String[] getFilenames()
	{
		Log.d(AppFacade.GetTag(), FilePathFacade.GetSavedDirectory());
		File savedWidgets = new File(FilePathFacade.GetSavedDirectory());
		savedWidgets.mkdirs();
		File[] files = savedWidgets.listFiles();
		
		if(null == files)
			return new String[]{""};
		
		String[] widgetNames = new String[files.length];
		int i = 0;
		
		
		for(File widget : savedWidgets.listFiles())
		{
			widgetNames[i] = widget.getName();
			i++;
		}
		
		return widgetNames;
	}
	
}
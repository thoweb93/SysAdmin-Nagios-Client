package com.SysAdmin.EventListener;

// java
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// android
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
// com.SysAdmin
import com.SysAdmin.AppFacade;
import com.SysAdmin.Activity.WidgetConfigure_Server;

/**
 * Event listener for the configuration activity.
 * Contains and handles every event of the configuration activity.
 * 
 * @author Lukas Bernreiter
 * @version 0.1, 19/02/2012
 * @since 0.1
 */
public class EventListener_Configuration_Server implements OnClickListener {

	// Objects
	private WidgetConfigure_Server configure = null;
	
	// Constructor
	public EventListener_Configuration_Server(){this(null);} 
	
	public EventListener_Configuration_Server(WidgetConfigure_Server _configure)
	{	
		if(null != _configure)
			this.configure = _configure;
	}
	
	/** Sets every event of the main configuration activity. */
	public void setEvents()
	{
		// Button Save
		this.configure.getButtonCheck().setOnClickListener(this);
	}
	
	/** Receives all click events of the main configuration activity. */
	public void onClick(View _v) {
		
		if(_v == this.configure.getButtonCheck())
		{
			InputStream inputStream = null;
			
			// Check if the connection is OK
			try {
				URL url = new URL(this.configure.getURL());
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				inputStream = new BufferedInputStream(connection.getInputStream(), 1024 * 5);
				
				
			} catch (Exception _e) {
				Log.e(AppFacade.GetTag(), _e.getMessage());
				this.configure.setDisplayResult(false);
			}
			finally{
				try {
					if(null != inputStream)
					{
						inputStream.close();
						this.configure.setDisplayResult(true);
					}				
				} catch (IOException _e) {
					Log.e(AppFacade.GetTag(), _e.getMessage());
				}
				
			}
			
		}
		
	}	
}

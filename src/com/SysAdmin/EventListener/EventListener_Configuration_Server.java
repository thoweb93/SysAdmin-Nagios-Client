package com.SysAdmin.EventListener;

// android
import android.view.View;
import android.view.View.OnClickListener;
// com.SysAdmin
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
			// Check
		}
		
	}
	
}

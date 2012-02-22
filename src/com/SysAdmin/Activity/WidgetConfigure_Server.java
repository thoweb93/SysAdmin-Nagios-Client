package com.SysAdmin.Activity;

import com.SysAdmin.AppFacade;
import com.SysAdmin.R;
import com.SysAdmin.EventListener.EventListener_Configuration_Server;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

/**
 * @author Lukas Bernreiter
 * @author Thomas Weber
 * @version 0.2, 22/02/2012
 * @since 0.1
 */
public class WidgetConfigure_Server extends Activity {
	
	// Objects
	private EventListener_Configuration_Server eventListener = null;
	
	// Constructor
	public WidgetConfigure_Server()
	{
		super();
	}
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle _icicle)
	{
		super.onCreate(_icicle);
		
		// set layout
		this.setContentView(R.layout.configuration);
			
		// set result to canceled
		// in case the user cancels the process
		this.setResult(Activity.RESULT_CANCELED);

		this.getWidgetId();
		
		this.initializeObjects();
	}
	
	/** Initializes every object of the main configuration activity */
	private void initializeObjects()
	{
		// set events
		this.eventListener = new EventListener_Configuration_Server(this);
		this.eventListener.setEvents();
	}
	
	/** Retrieves the application's widget id */
	private void getWidgetId()
	{
		Integer appWidgetId = AppFacade.GetAppWidgetId();
		Bundle extras = this.getIntent().getExtras();
        if (null != extras)
        	appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
            								AppWidgetManager.INVALID_APPWIDGET_ID);
		
        // set the new id
		try{
			AppFacade.SetAppWidgetId(appWidgetId);
		}catch(Exception _e)
		{
			Log.e(AppFacade.GetTag(), _e.getMessage());
			this.finish();
		}
	}
	
	public boolean onCreateOptionsMenu(Menu _menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, _menu);
		return true;
	}
	
	/** Called whenever a menu item gets clicked */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	    switch (item.getItemId()) {
	    	// start the next activity
	        case R.id.menuItemNext:
	        	Intent intent = new Intent(this, WidgetConfigure_Conclusion.class);
//				Intent intent = new Intent(this.configure, WidgetConfigure_Filter.class);
				
				this.startActivity(intent);
	            break;
	            
	        default:
	            return super.onOptionsItemSelected(item);	            
	    }
	    
	    return true;
	}
	
	/**
	 * Returns the check button
	 * @return the button used for checking the URL
	 * @see android.widget.Button
	 */
	public Button getButtonCheck(){ return (Button)this.findViewById(R.id.ButtonCheck);}

}

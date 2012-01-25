package com.ithtl.testWidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MyWidgetConfigure extends Activity{
	
	private int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	private Button buttonSave = null;
	private EventListener eventListener = null;
	
	public MyWidgetConfigure()
	{
		super();
	}
	
	public void onCreate(Bundle _icicle)
	{
		super.onCreate(_icicle);
		
		// set layout
		this.setContentView(R.layout.configuration);
		
		// set result to canceled
		// in case the user cancels the process
		this.setResult(Activity.RESULT_CANCELED);
		
		Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
		
        // check if the id is invalid
		if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
		
		this.buttonSave = (Button) this.findViewById(R.id.button1);
		
		this.eventListener = new EventListener(this);
		
	}
	
	/*
	 * Returns the save button
	 */
	public Button getButtonSave(){ return this.buttonSave;}
	
	/*
	 * Returns the widget id
	 */
	public int getAppWidgetId(){return this.mAppWidgetId;}

}

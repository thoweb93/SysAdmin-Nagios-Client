package com.SysAdmin.EventListener;

import java.util.Random;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RemoteViews;

import com.SysAdmin.R;
import com.SysAdmin.Activity.WidgetConfigure_Server;

/**
 * Event listener for the configuration activity.
 * Contains and handles every event of the configuration activity.
 * 
 * @author Lukas Bernreiter
 * @version 0.1, 19/02/2012S
 * @since 0.1
 */
public class EventListener_Configure implements OnClickListener {

	private WidgetConfigure_Server configure = null;
	
	/*
	 * Constructor	 
	 */
	public EventListener_Configure(){this(null);} 
	
	public EventListener_Configure(WidgetConfigure_Server _configure)
	{	
		if(this.configure != null)
		{
			this.configure = _configure;
			this.setEvents();
		}
	}
	
	
	private void setEvents()
	{
		// Button Save
		this.configure.getButtonSave().setOnClickListener(this);
	}
	
	public void onClick(View arg0) {
		
		if(arg0 == this.configure.getButtonSave())
		{
			Context context = this.configure.getApplicationContext();			
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			
			RemoteViews rViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			rViews.setTextViewText(R.id.textView_update, String.valueOf(new Random().nextInt(100)));
			appWidgetManager.updateAppWidget(this.configure.getAppWidgetId(), rViews);				
			
			Intent resultValue = new Intent();			
			resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, this.configure.getAppWidgetId());			
			this.configure.setResult(Activity.RESULT_OK, resultValue);			
			this.configure.finish();			
		}
		
	}
	
}

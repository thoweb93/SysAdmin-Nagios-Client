package com.SysAdmin.EventListener;

import java.util.Random;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RemoteViews;

import com.SysAdmin.R;
import com.SysAdmin.SysAdminWidgetConfigure;

public class EventListener_Widget implements OnClickListener {

private SysAdminWidgetConfigure configure = null;
	
	public EventListener_Widget(SysAdminWidgetConfigure _configure)
	{
		this.configure = _configure;
		
		this.setEvents();
	}
	
	/*
	 * Constructor	 
	 */
	private void setEvents()
	{
		// Button Save
		this.configure.getButtonSave().setOnClickListener(this);
	}
	
	public void onClick(View arg0) {
		
		if(arg0 == this.configure.getButtonSave())
		{
			Log.d("testWidget", "onClick");
			
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
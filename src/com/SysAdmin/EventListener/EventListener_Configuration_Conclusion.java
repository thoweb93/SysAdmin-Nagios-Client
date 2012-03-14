package com.SysAdmin.EventListener;


import com.SysAdmin.Activity.WidgetConfigure_Conclusion;

/**
 * @author Lukas Bernreiter
 * @version 0.2, 22/02/2012
 * @since 0.2
 */
public class EventListener_Configuration_Conclusion 
{
	// Objects
	private WidgetConfigure_Conclusion conclusion = null;
	
	// Constructor
	public EventListener_Configuration_Conclusion(WidgetConfigure_Conclusion _conclusion)
	{
		this.conclusion = _conclusion;
	}
	
	public void setEvents()
	{
		// EventsDownload, parse and fill cursor
	}
	
	/*
	 * 		Add Activity
	 * 	----------------------------------------------------------------------------------
	 * 		Context context = this.configure.getApplicationContext();			
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			
			RemoteViews rViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
			rViews.setTextViewText(R.id.textView_update, String.valueOf(new Random().nextInt(100)));
			appWidgetManager.updateAppWidget(this.configure.getAppWidgetId(), rViews);				
			
			Intent resultValue = new Intent();			
			resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, this.configure.getAppWidgetId());			
			this.configure.setResult(Activity.RESULT_OK, resultValue);			
			this.configure.finish();
	 */
}

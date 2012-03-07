package com.SysAdmin;

// android
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Broadcast receiver, receives intent concerning the widget.
 * 
 * @author Lukas Bernreiter
 * @version 0.2, 19/02/2012
 * @since 0.1
 */
public class SysAdminWidgetProvider extends AppWidgetProvider {
	
	public static final String UPDATE_ACTION = "com.SysAdmin.APPWIDGET_UPDATE";

	@Override
    public void onReceive(Context context, Intent intent) {
       
        final String action = intent.getAction();
        
        if (UPDATE_ACTION.equals(action)) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            ComponentName componentName = new ComponentName(context, SysAdminWidgetProvider.class);
            
            this.performUpdate(context, appWidgetManager, appWidgetManager.getAppWidgetIds(getComponentName(context)));
            
            appWidgetManager.notifyAppWidgetViewDataChanged(
            		appWidgetManager.getAppWidgetIds(componentName), R.id.listView_Status_List);
        } 
        else
        	super.onReceive(context, intent);
    }
	 
	private static ComponentName getComponentName(Context context) 
	{
	        return new ComponentName(context, SysAdminWidgetProvider.class);
	}
		
	@Override
    public void onUpdate(Context context, AppWidgetManager mngr, int[] ids) {
        this.performUpdate(context, mngr, ids);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
    
    private void performUpdate(Context _context, AppWidgetManager appWidgetManager, int[] appWidgetIds) 
    {
	
		for (int widgetId : appWidgetIds) 
		{
	    	final Intent intent = new Intent(_context, UpdateService.class);
			intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds);
			
			final RemoteViews rViews = new RemoteViews(_context.getPackageName(), R.layout.widget_layout);
			rViews.setRemoteAdapter(widgetId, R.id.listView_Status_List, intent);
			rViews.setEmptyView(R.id.listView_Status_List, R.id.empty_view);
			
			// create click event for the refresh button
			final Intent refreshIntent = new Intent(_context, SysAdminWidgetProvider.class);
			refreshIntent.setAction(SysAdminWidgetProvider.UPDATE_ACTION);
			final PendingIntent refreshPendingIntent = PendingIntent.getBroadcast(_context,
					0, refreshIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			// set click event
			rViews.setOnClickPendingIntent(R.id.imageButton_Refresh, refreshPendingIntent);
			
			appWidgetManager.updateAppWidget(widgetId, rViews);
		}
    }		
	
}

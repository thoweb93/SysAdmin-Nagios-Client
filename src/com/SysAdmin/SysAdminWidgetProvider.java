package com.SysAdmin;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class SysAdminWidgetProvider extends AppWidgetProvider {

	 public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	        final int N = appWidgetIds.length;

	        Log.w("WidgetExample", "Widget - onUpdate");
	        
	        // Perform this loop procedure for each App Widget that belongs to this provider
	        for (int i=0; i<N; i++) {
	            int appWidgetId = appWidgetIds[i];
	            
	            int number = (new Random().nextInt(100));
	            
	            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
				Log.w("WidgetExample", String.valueOf(number));
	            
				remoteViews.setTextViewText(R.id.textView_update, String.valueOf(number));
				
				Intent intent = new Intent(context, SysAdminWidgetProvider.class);

				intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
				intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

				PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				remoteViews.setOnClickPendingIntent(R.id.textView_update, pendingIntent);
				appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
				
	        }
	    }
	
}

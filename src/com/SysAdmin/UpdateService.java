package com.SysAdmin;

// android
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class UpdateService extends RemoteViewsService 
{
	@Override
	public RemoteViewsFactory onGetViewFactory(Intent _intent) {
		return new UpdateRemoteViewsFactory(this.getApplicationContext(), _intent);
	}
}

class UpdateRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory
{
	private Context mContext = null;
	private Integer mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	private Cursor mCursor = null;

	public UpdateRemoteViewsFactory(Context _context, Intent _intent)
	{
		this.mContext = _context;
		this.mAppWidgetId = _intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
	}
	
	public int getCount() {
		if(mCursor != null)
			return mCursor.getCount();
		else
			return 0;
	}

	public long getItemId(int _position) {
		return _position;
	}

	public RemoteViews getLoadingView() {
		return null;
	}

	public RemoteViews getViewAt(int _position) {

		RemoteViews rViews = new RemoteViews(this.mContext.getPackageName(), R.layout.list_item);
		rViews.setTextViewText(R.id.textView_Service, String.valueOf(_position));			
		
		return rViews;
	}

	public int getViewTypeCount() {
		return 1;
	}

	public boolean hasStableIds() {
		return true;
	}

	public void onCreate() {		
		// no-op
	}

	public void onDataSetChanged() {
		if(null != this.mCursor)
			this.mCursor.close();
		
		// Download, parse and fill cursor
	}

	public void onDestroy() {
		if(null != this.mCursor)
			this.mCursor.close();
	}
	
}
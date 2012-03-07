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
		return mCursor.getCount();
	}

	public long getItemId(int _position) {
		return _position;
	}

	public RemoteViews getLoadingView() {
		return null;
	}

	public RemoteViews getViewAt(int _position) {
		// TODO: getViewAt()
		return null;
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
		// DOWNLOAD AND PARSE HERE
	}

	public void onDestroy() {
		if(null != this.mCursor)
			this.mCursor.close();
	}
	
}
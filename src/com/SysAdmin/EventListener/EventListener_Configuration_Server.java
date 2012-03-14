package com.SysAdmin.EventListener;

// java
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

// android
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
// com.SysAdmin
import com.SysAdmin.AppFacade;
import com.SysAdmin.Activity.WidgetConfigure_Server;

/**
 * Event listener for the configuration activity.
 * Contains and handles every event of the configuration activity.
 * 
 * @author Lukas Bernreiter
 * @version 0., 14/03/2012
 * @since 0.1
 */
public class EventListener_Configuration_Server implements OnClickListener, Runnable {

	// Objects
	private WidgetConfigure_Server mConfigure = null;
	private ByteArrayBuffer mByteArrayBuffer  = null;
	private ProgressDialog mProgressDialog 	  = null;
	private Boolean mFailure 				  = false;
	private final Integer CAPACITY 			  = 50; 	
	
	/**
	 * Default Constructor
	 */
	public EventListener_Configuration_Server(){this(null);} 
	
	/**
	 * Constructor, stores the instance of the configure activity.
	 * 
	 * @param _configure The instance.
	 */
	public EventListener_Configuration_Server(WidgetConfigure_Server _configure)
	{	
		if(null != _configure)
			this.mConfigure = _configure;
		
		this.initializeObjects();
	}
	
	/** Initializes every object */
	private void initializeObjects()
	{
		this.mByteArrayBuffer = new ByteArrayBuffer(CAPACITY);
	}
	
	/** Sets every event of the main configuration activity. */
	public void setEvents()
	{
		// Button Save
		this.mConfigure.getButtonCheck().setOnClickListener(this);
	}
	
	/** Receives all click events of the main configuration activity. */
	public void onClick(View _v) {
		
		if(_v == this.mConfigure.getButtonCheck())
		{
			mProgressDialog = ProgressDialog.show(this.mConfigure, "", "Downloading file", false);
			Thread thread = new Thread(this);
			thread.start();
		}
		
	}
	
	public void run() {
		InputStream inputStream = null;
		
		// Check if the connection is OK
		try {
			URL url = new URL(this.mConfigure.getURL());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			inputStream = new BufferedInputStream(connection.getInputStream(), 1024 * 5);				
			int current = 0;
			
			while((current = inputStream.read()) != -1)
				this.mByteArrayBuffer.append((byte)current);
			
		} catch (Exception _e) {
			Log.e(AppFacade.GetTag(), _e.getMessage());
			mFailure = false;
		}
		finally{
			try {
				if(null != inputStream)
				{
					inputStream.close();
					mFailure = true;
				}				
			} catch (IOException _e) {
				Log.e(AppFacade.GetTag(), _e.getMessage());
			}
		}
		// update UI
		handler.sendEmptyMessage(0);
	}
	
	private Handler handler = new Handler()
	{
		@Override
        public void handleMessage(Message msg) {
			mProgressDialog.dismiss();
			 
			mConfigure.setDisplayResult(mFailure);
        }
	};
	
	public ByteArrayBuffer getByteArrayBuffer() { 
		return this.mByteArrayBuffer; 
	}
}

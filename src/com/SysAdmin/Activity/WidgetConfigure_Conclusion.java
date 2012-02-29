package com.SysAdmin.Activity;


import com.SysAdmin.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Last configuration activity.
 * Concludes the settings entered by the user.
 * 
 * @author Lukas Bernreiter
 * @version 0.1, 19/02/2012S
 * @since 0.1
 */
public class WidgetConfigure_Conclusion extends Activity {
	
	public WidgetConfigure_Conclusion()
	{
		super();
	}
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle _icicle)
	{
		super.onCreate(_icicle);
		
		// set layout
		this.setContentView(R.layout.conclusion);			
	
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
	}	

	/** Called when the menu gets created */
	@Override
	public boolean onCreateOptionsMenu(Menu _menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.final_menu, _menu);
		return true;
	}
	
	/** Called whenever a menu item gets clicked */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, WidgetConfigure_Server.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            
	            break;
	        case R.id.menuItemSave:
	        	
	            
	        	break;
	        case R.id.menuItemFinish:
	        	this.setResult(RESULT_OK);
	        	this.finish();
	        	break;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    
	    return true;
	}
	
	
	
}

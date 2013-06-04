package com.balusoft.balusoftapiconsumer;

import com.balusoft.balusoftapiconsumer.helpers.WebRequestHelper;
import com.balusoft.balusoftapiconsumer.services.PersonasService;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private final String TAG = MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"OnCreate event");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void btnSearchClick(View v){
		TextView txtName = (TextView)findViewById(R.id.txtName);
		String searchName = txtName.getText().toString();
		
		new PersonasService.SearchPeopleByNameTask(getApplicationContext()).execute(searchName);
	}
}

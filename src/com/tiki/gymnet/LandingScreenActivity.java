package com.tiki.gymnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class LandingScreenActivity extends Activity implements OnClickListener
{
	
	TextView loginBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_landing_screen);
		
		loginBtn = (TextView) findViewById(R.id.log_in);
		loginBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.log_in:
			Intent i = new Intent(this,SignInActivity.class);
			startActivity(i);
			finish();
			break;
		}
	}

}

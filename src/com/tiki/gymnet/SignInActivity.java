package com.tiki.gymnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SignInActivity extends Activity implements OnClickListener
{
	
	TextView loginBtn;
	View progress;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		
		loginBtn = (TextView) findViewById(R.id.log_in);
		progress = findViewById(R.id.progress);
		
		loginBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.log_in:
			progress.setVisibility(View.VISIBLE);
			progress.postDelayed(new Runnable(){

				@Override
				public void run() {
					Intent i = new Intent(SignInActivity.this, HomeActivity.class);
					SignInActivity.this.startActivity(i);
					SignInActivity.this.finish();
				}}, 1000);
			break;
		}
	}
	
	@Override
	public void onBackPressed()
	{
		Intent i = new Intent(this,LandingScreenActivity.class);
		startActivity(i);
		finish();
	}

}

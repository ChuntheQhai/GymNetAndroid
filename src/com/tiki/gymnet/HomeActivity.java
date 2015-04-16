package com.tiki.gymnet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tiki.gymnet.fragment.FeedPageFragment;
import com.tiki.gymnet.fragment.NewsFeedFragment;

public class HomeActivity extends BaseActivity
{
	
	View container;
	
	public static int inboxIndex;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		container = findViewById(R.id.container);
		
		changeFragment( new FeedPageFragment() );
	}
	
	@Override
	public void onBackPressed()
	{
		Fragment f = getSupportFragmentManager().findFragmentByTag("frag");
		if (f!=null)
		{
			if (f instanceof FeedPageFragment)
			{
				super.onBackPressed();
			}
			else
				changeFragment( new FeedPageFragment() );
		}
	}

}

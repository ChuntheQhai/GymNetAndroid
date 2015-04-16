package com.tiki.gymnet;

import com.tiki.gymnet.fragment.CheckInFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

public class BaseCheckinActivity extends BaseActivity
{
	
	public static String placename;
	public static String address;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_checkin);
		cabText.setVisibility(View.GONE);
		cabTitle.setVisibility(View.VISIBLE);
		
		changeFragment(new CheckInFragment());
	}
	
	@Override
	public void onBackPressed()
	{
		previousFragment();
	}

	
	public void previousFragment()
	{
		FragmentManager fm = getSupportFragmentManager();
		if (fm.getBackStackEntryCount() == 0)
		{
			finish();
			return;
		}
		else
			fm.popBackStack();
	}
}

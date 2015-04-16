package com.tiki.gymnet.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tiki.gymnet.fragment.NewsFeedFragment;

public class FeedPageAdapter extends FragmentStatePagerAdapter {

	final String[] titles = {"Friends","Others","Recommended"};
	
    public FeedPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
    	NewsFeedFragment frag = new NewsFeedFragment();
    	frag.setMode(pos);
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
    
    @Override
    public String getPageTitle(int i)
    {
    	return titles[i];
    }

}

package com.tiki.gymnet.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiki.gymnet.R;
import com.tiki.gymnet.adapter.FeedPageAdapter;
import com.viewpagerindicator.TitlePageIndicator;

public class FeedPageFragment extends Fragment
{
	FeedPageAdapter adapter;
	ViewPager pager;
	TitlePageIndicator titles;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_feed, container,false);
		
		pager = (ViewPager) v.findViewById(R.id.vp);
		titles = (TitlePageIndicator) v.findViewById(R.id.title_indicator);
		titles.setTextColor(Color.BLACK);
		titles.setSelectedColor(getResources().getColor(R.color.yellow));
		titles.setFooterColor(getResources().getColor(R.color.yellow));
		
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		adapter = new FeedPageAdapter(getFragmentManager());
		pager.setAdapter(adapter);
		titles.setViewPager(pager);
	}

}

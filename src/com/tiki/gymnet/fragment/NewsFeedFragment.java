package com.tiki.gymnet.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.tiki.gymnet.BaseCheckinActivity;
import com.tiki.gymnet.R;
import com.tiki.gymnet.adapter.FeedListAdapter;
import com.tiki.gymnet.models.Feed;

public class NewsFeedFragment extends Fragment
{
	ListView lv;
	ImageView cta;
	FeedListAdapter adapter;
	int mode = 1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_newsfeed_list, container, false);
		
		lv = (ListView) v.findViewById(R.id.lv);
		cta = (ImageView) v.findViewById(R.id.cta_btn);
		cta.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(), BaseCheckinActivity.class);
				startActivity(i);
			}
		});
		
		return v;
	}
	
	public void setMode(int mode)
	{
		this.mode = mode;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		if(mode == 0)
		{
			Feed f1 = new Feed(R.drawable.first, "2m ago", "John", "Fitness First Paradigm", "Biceps,heaving lifting!", "", 5, null, false);
			Feed f2 = new Feed(R.drawable.first, "10m ago", "John", "Fitness First Paradigm", "Cardio,zumba!", "", 5, null, true);
			Feed f3 = new Feed(R.drawable.second, "45m ago", "Andy", "One More Rep Gym", "Soulder and biceps,toning up", "", 5, null, true);
			Feed f4 = new Feed(R.drawable.third, "1 hour ago", "Chelsea", "JATOMI Fitness Tropicana City", "Chest and triceps, heavy lifting!", "", 5, null, false);
			Feed f5 = new Feed(R.drawable.second, "1 day ago", "Andy", "California Fitness Subang Parade", "Legs,heavy squat", "", 5, null, false);
			Feed f6 = new Feed(R.drawable.third, "2 days ago", "Chelsea", "JATOMI Fitness Tropicana City", "Heavy cardio,treadmill", "", 5, null, false);
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			feeds.add(f1);
			feeds.add(f2);
			feeds.add(f3);
			feeds.add(f4);
			feeds.add(f5);
			feeds.add(f6);
			adapter = new FeedListAdapter(getActivity(), feeds);
			lv.setAdapter(adapter);
		}
		else if (mode == 1)
		{
			Feed f1 = new Feed(R.drawable.first, "2m ago", "John", "Fitness First Paradigm", "Leg days! Never forget leg days!", "", 5, null, false);
			Feed f2 = new Feed(R.drawable.forth, "10m ago", "John", "Fitness First Paradigm", "Cant wait for my workout today!", "", 5, null, true);
			Feed f3 = new Feed(R.drawable.third, "45m ago", "Andy", "One More Rep Gym", "Feeling macho!", "", 5, null, true);
			Feed f4 = new Feed(R.drawable.second, "1 hour ago", "Chelsea", "JATOMI Fitness Tropicana City", "Classes was pack but super fun!", "", 5, null, false);
			Feed f5 = new Feed(R.drawable.forth, "1 day ago", "Andy", "California Fitness Subang Parade", "Im coming!", "", 5, null, false);
			Feed f6 = new Feed(R.drawable.third, "2 days ago", "Chelsea", "JATOMI Fitness Tropicana City", "Heavy cardio and HIIT...", "", 5, null, false);
			Feed f7 = new Feed(R.drawable.first, "2m ago", "John", "Fitness First Paradigm", "Leg days! Never forget leg days!", "", 5, null, false);
			Feed f8 = new Feed(R.drawable.third, "10m ago", "John", "Fitness First Paradigm", "Cant wait for my workout today!", "", 5, null, true);
			Feed f9 = new Feed(R.drawable.forth, "45m ago", "Andy", "One More Rep Gym", "Feeling macho!", "", 5, null, true);
			Feed f10 = new Feed(R.drawable.third, "1 hour ago", "Chelsea", "JATOMI Fitness Tropicana City", "Classes was pack but super fun!", "", 5, null, false);
			Feed f11 = new Feed(R.drawable.first, "1 day ago", "Andy", "California Fitness Subang Parade", "Im coming!", "", 5, null, false);
			Feed f12 = new Feed(R.drawable.second, "2 days ago", "Chelsea", "JATOMI Fitness Tropicana City", "Heavy cardio and HIIT...", "", 5, null, false);
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			feeds.add(f1);
			feeds.add(f2);
			feeds.add(f3);
			feeds.add(f4);
			feeds.add(f5);
			feeds.add(f6);
			feeds.add(f7);
			feeds.add(f8);
			feeds.add(f9);
			feeds.add(f10);
			feeds.add(f11);
			feeds.add(f12);
			adapter = new FeedListAdapter(getActivity(), feeds);
			lv.setAdapter(adapter);
		}
		else if (mode == 2)
		{
			Feed f1 = new Feed(R.drawable.second, "2m ago", "John", "Fitness First Paradigm", "Leg days! Never forget leg days!", "", 5, null, false);
			Feed f2 = new Feed(R.drawable.third, "10m ago", "John", "Fitness First Paradigm", "Cant wait for my workout today!", "", 5, null, true);
			Feed f3 = new Feed(R.drawable.first, "45m ago", "Andy", "One More Rep Gym", "Feeling macho!", "", 5, null, true);
			Feed f4 = new Feed(R.drawable.forth, "1 hour ago", "Chelsea", "JATOMI Fitness Tropicana City", "Classes was pack but super fun!", "", 5, null, false);
			Feed f5 = new Feed(R.drawable.ic_launcher, "1 day ago", "Andy", "California Fitness Subang Parade", "Im coming!", "", 5, null, false);
			Feed f6 = new Feed(R.drawable.ic_launcher, "2 days ago", "Chelsea", "JATOMI Fitness Tropicana City", "Heavy cardio and HIIT...", "", 5, null, false);
			ArrayList<Feed> feeds = new ArrayList<Feed>();
			feeds.add(f1);
			feeds.add(f2);
			feeds.add(f3);
			feeds.add(f4);
			feeds.add(f5);
			feeds.add(f6);
			adapter = new FeedListAdapter(getActivity(), feeds);
			lv.setAdapter(adapter);
		}
		
		
		
		
	}

}

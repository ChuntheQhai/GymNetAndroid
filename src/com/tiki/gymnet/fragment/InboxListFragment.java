package com.tiki.gymnet.fragment;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.tiki.gymnet.BaseActivity;
import com.tiki.gymnet.R;
import com.tiki.gymnet.adapter.InboxListAdapter;
import com.tiki.gymnet.models.Inbox;

public class InboxListFragment extends Fragment {
	
	ListView lv;
	ImageView cta;
	InboxListAdapter adapter;
	BaseActivity activity;

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = (BaseActivity) activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_inbox_list, container, false);
		
		lv = (ListView) v.findViewById(R.id.lv);
		cta = (ImageView) v.findViewById(R.id.cta_btn);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				activity.changeFragment(new MessageListFragment());
				
			}
		});
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		DateFormat df = new SimpleDateFormat("h:mm a");
		String date = df.format(Calendar.getInstance().getTime());
		
		Inbox i1 = new Inbox(R.drawable.first, "John", "" + date, "What's Up?");
		Inbox i2 = new Inbox(R.drawable.second, "Chealsea",  "" + date, "Hello");
		Inbox i3 = new Inbox(R.drawable.third, "Alexander",  "" + date, "Good Morning!");
		Inbox i4 = new Inbox(R.drawable.forth, "Kelvin",  "" + date, "Hey, Good Night!");
		
	
		ArrayList<Inbox> inboxes = new ArrayList<Inbox>();
		inboxes.add(i1);
		inboxes.add(i2);
		inboxes.add(i3);
		inboxes.add(i4);
		
		
		adapter = new InboxListAdapter(getActivity(),inboxes);
		lv.setAdapter(adapter);

		


		
	}
	
}

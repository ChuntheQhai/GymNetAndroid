package com.tiki.gymnet.fragment;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import java.text.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.tiki.gymnet.R;
import com.tiki.gymnet.adapter.MessageListAdapter;
import com.tiki.gymnet.models.Message;

public class MessageListFragment extends Fragment{
	
	ListView lv;
	ImageView cta;
	MessageListAdapter adapter;
	ImageView sendMessage;
	EditText messageText;
	ArrayList<Message> messages; 
	DateFormat df = new SimpleDateFormat("h:mm a");
	String date = df.format(Calendar.getInstance().getTime());
	Message msg;

	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_messages, container, false);
		
		lv = (ListView) v.findViewById(R.id.lv);
		cta = (ImageView) v.findViewById(R.id.cta_btn);
		sendMessage = (ImageView) v.findViewById(R.id.sendMessage);
		messageText = (EditText) v.findViewById(R.id.messageText);
		messages = new ArrayList<Message>();
		
		sendMessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
				msg = new Message(R.drawable.ic_launcher,""+date,messageText.getText().toString());
				adapter.addMessage(msg);
//				messages.add(msg);
//				adapter = new MessageListAdapter(getActivity(),messages);
//				lv.setTranscriptMode(lv.TRANSCRIPT_MODE_ALWAYS_SCROLL);
//				lv.setAdapter(adapter);
//				
//				adapter.notifyDataSetChanged();
				lv.post(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
			            lv.setSelection(adapter.getCount() - 1);

					}});
				
			}
		});
		
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Message m1 = new Message(R.drawable.ic_launcher,"12:05PM","Hey dude, let's workout together.");
		messages.add(m1);
		
		
		adapter = new MessageListAdapter(getActivity(),messages);
		lv.setAdapter(adapter);
		
	}
	

}

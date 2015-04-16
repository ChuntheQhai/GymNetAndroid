package com.tiki.gymnet.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.tiki.gymnet.R;
import com.tiki.gymnet.models.Message;


public class MessageListAdapter extends BaseAdapter{
	
	Context c;
	ArrayList<Message> messages;
	
	public MessageListAdapter(Context c, ArrayList<Message> messages)
	{
		this.c = c;
		this.messages = messages;
		
		if(messages == null)
			messages = new ArrayList<Message>();
	}
	
	public void addMessage(Message m)
	{
		if(messages==null)
				return;
		messages.add(m);
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return messages.size();
	}
	
	@Override
	public Object getItem(int arg0) {
		return null;
	}
	
	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	
	class ViewHolder
	{
		CircularImageView userImage;
		TextView message;
		TextView time;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View v = convertView;
		ViewHolder vh;
		
		if(v == null)
		{
			v = LayoutInflater.from(c).inflate(R.layout.item_message,parent,false);
			vh = new ViewHolder();
			
			vh.userImage = (CircularImageView) v.findViewById(R.id.inf_pic);
			vh.message = (TextView) v.findViewById(R.id.inf_message);
			vh.time = (TextView) v.findViewById(R.id.inf_time);
			
			v.setTag(vh);
		}
		else 
		{
			vh = (ViewHolder) v.getTag();
		}
		
		Message m = messages.get(position);
		vh.userImage.setImageResource(m.getUserImage());
		vh.message.setText(m.getMessages());
		vh.time.setText(m.getTime());
		return v;
	}
	
}

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
import com.tiki.gymnet.models.Inbox;

public class InboxListAdapter extends BaseAdapter{
		
	Context c;
	ArrayList<Inbox> inboxes;
	
	public InboxListAdapter(Context c, ArrayList<Inbox> inboxes)
	{
		this.c = c;
		this.inboxes = inboxes;
		
		if (inboxes == null)
			inboxes = new ArrayList<Inbox>();
			
	}
	
	@Override
	public int getCount() {
		return inboxes.size();
	}
	
	@Override
	public Object getItem(int position)
	{
		return null;
	}
	
	@Override
	public long getItemId(int position)
	{
		return 0;
	}
	
	class ViewHolder
	{
		CircularImageView userImage;
		TextView userName;
		TextView time;
		TextView message;
	}
	
	@Override
	public View getView(int position,View convertView, ViewGroup parent)
	{
		View v = convertView;
		ViewHolder vh;
		
		if(v == null)
		{
			v= LayoutInflater.from(c).inflate(R.layout.item_inbox, parent, false);
			vh = new ViewHolder();
			
			vh.userImage = (CircularImageView) v.findViewById(R.id.inf_pic);
			vh.userName = (TextView) v.findViewById(R.id.inf_username);
			vh.time = (TextView) v.findViewById(R.id.inf_time);
			vh.message = (TextView) v.findViewById(R.id.inf_message);
			
			v.setTag(vh);
		}
		else
		{
			vh = (ViewHolder) v.getTag();
		}

		Inbox i = inboxes.get(position);
		vh.userImage.setImageResource(i.getUserImage());
		vh.userName.setText(i.getUserName());
		vh.time.setText(i.getTime());
		vh.message.setText(i.getMessage());
		return v;
	}
	
	
	
}

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
import com.tiki.gymnet.models.Feed;

public class FeedListAdapter extends BaseAdapter{

	Context c;
	ArrayList<Feed> feeds;
	
	public FeedListAdapter(Context c, ArrayList<Feed> feeds)
	{
		this.c = c;
		this.feeds = feeds;
		
		if (feeds == null)
			feeds = new ArrayList<Feed>();
	}
	
	@Override
	public int getCount() {
		return feeds.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	class ViewHolder
	{
		CircularImageView pic;
		TextView username;
		TextView location;
		TextView time;
		TextView message;
		TextView likes;
		TextView comments;
		TextView otw;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder vh;
		if (v == null)
		{
			v = LayoutInflater.from(c).inflate(R.layout.item_news_feed, parent, false);
			vh = new ViewHolder();
			
			vh.pic = (CircularImageView) v.findViewById(R.id.inf_pic);
			vh.username = (TextView) v.findViewById(R.id.inf_username);
			vh.location = (TextView) v.findViewById(R.id.inf_location);
			vh.time = (TextView) v.findViewById(R.id.inf_time);
			vh.message = (TextView) v.findViewById(R.id.inf_message);
			vh.likes = (TextView) v.findViewById(R.id.inf_likes);
			vh.comments = (TextView) v.findViewById(R.id.inf_comments);
			vh.otw = (TextView) v.findViewById(R.id.inf_otw);
			v.setTag(vh);
		}
		else
			vh = (ViewHolder) v.getTag();
		
		Feed f = feeds.get(position);
		vh.pic.setImageResource(f.getUserImage());
		vh.username.setText(f.getUserName());
		vh.location.setText(f.getLocation());
		vh.time.setText(f.getTime());
		vh.message.setText(f.getMessage());
		vh.likes.setText(""+f.getLike());
		vh.comments.setText(""+f.getCommentList().size());
		if (f.isOTW())
		{
			vh.otw.setText("Im on the way! Eta "+((int)(Math.random()*100))+" minutes.");
			vh.otw.setVisibility(View.VISIBLE);
		}
		else
			vh.otw.setVisibility(View.GONE);
		
		return v;
	}

}

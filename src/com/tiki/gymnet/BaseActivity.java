package com.tiki.gymnet;

import com.tiki.gymnet.fragment.FeedPageFragment;
import com.tiki.gymnet.fragment.InboxListFragment;

import android.app.ActionBar;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class BaseActivity extends FragmentActivity implements OnClickListener
{
	
	TextView cabText;
	TextView cabTitle;
	PopupWindow dropdown;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);		
		setUpCustomActionBar();
	}
	
	private void setUpCustomActionBar()
	{
		View cab = LayoutInflater.from(this).inflate(R.layout.custom_action_bar, null);
		
		final ActionBar ab = getActionBar();
	    ab.setDisplayShowHomeEnabled(false);
	    ab.setDisplayShowTitleEnabled(false);
	    ab.setDisplayShowCustomEnabled(true);
		cabText = (TextView) cab.findViewById(R.id.cab_text);
		cabTitle = (TextView) cab.findViewById(R.id.cab_title);
		cabText.setOnClickListener(this);
		
		ab.setCustomView(cab,new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.cab_text:
			showDropDownPopup();
			break;
		}
	}
	
	private void showDropDownPopup()
	{
		View content = LayoutInflater.from(this).inflate(R.layout.popup_listview, null);
		ListView lv = (ListView) content.findViewById(R.id.popup_lv);
		lv.setAdapter(new DropDownPopupAdapter());
		lv.setOnItemClickListener(dropDownItemClick);
		dropdown = new PopupWindow(content, 650,
				LayoutParams.WRAP_CONTENT);
		dropdown.setBackgroundDrawable(new BitmapDrawable());
		dropdown.setOutsideTouchable(true);
		dropdown.setTouchable(true);
		dropdown.setFocusable(true);
		dropdown.setContentView(content);
		
		dropdown.showAsDropDown(cabText);
	}
	
	class DropDownPopupAdapter extends BaseAdapter
	{
		final int[] icons = {R.drawable.newspaper, R.drawable.house, R.drawable.message, R.drawable.profile, R.drawable.settings};
		final String[] texts = {"News feed", "In your gym", "Inbox", "Profile", "Settings" };

		@Override
		public int getCount() {
			return texts.length;
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
			TextView text;
			ImageView icon;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			ViewHolder vh;
			if (v == null)
			{
				v = LayoutInflater.from(BaseActivity.this).inflate(R.layout.item_drop_down, parent, false);
				vh = new ViewHolder();
				
				vh.icon = (ImageView) v.findViewById(R.id.icon);
				vh.text = (TextView) v.findViewById(R.id.text);
				
				v.setTag(vh);
			}
			else
				vh = (ViewHolder) v.getTag();
			
			vh.icon.setImageResource(icons[position]);
			vh.text.setText(texts[position]);
			
			return v;
		}
		
	}
	
	public void changeFragment(Fragment frag)
	{
		if (getSupportFragmentManager().findFragmentByTag("frag")!=null)
			getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_to_right).replace(R.id.container, frag, "frag").commit();
		else
			getSupportFragmentManager().beginTransaction().add(R.id.container, frag, "frag").commit();
		
		if (dropdown!=null && dropdown.isShowing())
			dropdown.dismiss();
	}
	
	public void changeFragmentWithBackstack(Fragment frag)
	{
		if (getSupportFragmentManager().findFragmentByTag("frag")!=null)
			getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_to_right).replace(R.id.container, frag, "frag").addToBackStack(null).commit();
		else
			getSupportFragmentManager().beginTransaction().add(R.id.container, frag, "frag").commit();
		
		if (dropdown!=null && dropdown.isShowing())
			dropdown.dismiss();
	}
	
	OnItemClickListener dropDownItemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			switch (position)
			{
			case 0:
				changeFragment(new FeedPageFragment());
				cabText.setText("News feed");
				break;
			case 1:
				changeFragment(new FeedPageFragment());
				cabText.setText("In your gym");
				break;
			case 2:
				changeFragment(new InboxListFragment());
				cabText.setText("Inbox");
				break;
			case 3:
				cabText.setText("Profile");
				break;
			case 4:
				cabText.setText("Settings");
				break;
			}
		}
	};

}

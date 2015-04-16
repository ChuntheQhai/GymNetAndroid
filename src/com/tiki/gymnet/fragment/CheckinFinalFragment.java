package com.tiki.gymnet.fragment;

import com.tiki.gymnet.BaseCheckinActivity;
import com.tiki.gymnet.R;
import com.tiki.gymnet.R.id;
import com.tiki.gymnet.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckinFinalFragment extends Fragment
{
	
	TextView placename;
	TextView address;
	EditText postStatus;
	View login;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_checkin_final, container,false);
		
		placename = (TextView)v.findViewById(R.id.placename);
		address = (TextView)v.findViewById(R.id.address);
		login = v.findViewById(R.id.log_in);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Checked in!", Toast.LENGTH_LONG).show();
				getActivity().finish();
			}
		});
		
		placename.setText(BaseCheckinActivity.placename);
		address.setText(BaseCheckinActivity.address);
		
		
		return v;
	}

}

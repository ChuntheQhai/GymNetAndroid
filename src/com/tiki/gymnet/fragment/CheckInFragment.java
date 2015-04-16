package com.tiki.gymnet.fragment;

import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.tiki.gymnet.BaseCheckinActivity;
import com.tiki.gymnet.R;
import com.tiki.gymnet.R.drawable;
import com.tiki.gymnet.R.id;
import com.tiki.gymnet.R.layout;
import com.tiki.gymnet.models.FResponse;
import com.tiki.gymnet.models.FVenue;

public class CheckInFragment extends Fragment
{
	final LatLng TM = new LatLng(3.1152076,101.6665363);

	GoogleMap mMap;
	View pb;
	ListView lv;
	GymPlacesAdapter adapter;
	ArrayList<FVenue> ven;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		super.onCreateView(inflater, container, savedInstanceState);
		
		View v = inflater.inflate(R.layout.fragment_checkin, container,false);
		
		pb = v.findViewById(R.id.pb);
		lv = (ListView)v.findViewById(R.id.lv);
		
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		setUpMapIfNeeded();
	}
	
	private void setUpMapIfNeeded() {
	    // Do a null check to confirm that we have not already instantiated the map.
	    if (mMap == null) {
	        mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map))
	                            .getMap();
	        // Check if we were successful in obtaining the map.
	        if (mMap != null) {
	            // The Map is verified. It is now safe to manipulate the map.
	        	mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TM, 8));
	        	mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
	        	getFoursquareGyms();
	        }
	    }
	}
	
	private void getFoursquareGyms()
	{
		RequestQueue rq = Volley.newRequestQueue(getActivity());
		
		final String url = "https://api.foursquare.com/v2/venues/search?client_id=UU4VHA0F3NT3W55MUM34QGRF41ZVLI3CKO2SQSSQNOINRWWY&client_secret=NVYBGZMDERFVAW534EKQ1KJTE0U1O24PZ1J2DHR21YQQFUBQ&v=20130815&ll=3.1357,101.6880&llAcc=1600&categoryId=4bf58dd8d48988d176941735";
		
		JsonObjectRequest foursquareAPISearch = new JsonObjectRequest(
				Request.Method.GET, 
				url,
				null, 
				new Response.Listener<JSONObject>() 
				{

			@Override
			public void onResponse(JSONObject response) {
				Log.e("API","response = "+response);
				Gson gson = new Gson();
				FResponse data = gson.fromJson(response.toString(), FResponse.class);
				if (data == null)
					Toast.makeText(getActivity(), "Sorry, an elephant appeared and blocked the way.", 1).show();
				else
				{
					ven = data.getResponse().getVenues();
					adapter = new GymPlacesAdapter(data.getResponse().getVenues()); 
					lv.setAdapter(adapter);
					lv.setOnItemClickListener(itemClick);
					lv.setVisibility(View.VISIBLE);
					pb.setVisibility(View.GONE);
					
					addMarkers(data.getResponse().getVenues());
				}
				
			}
		}, 
		new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("A","error");
			}
		});
		
		rq.add(foursquareAPISearch);
	}
	
	private void addMarkers(ArrayList<FVenue> venues)
	{
		for (int i = 0; i<venues.size() ; i++)
		{
			mMap.addMarker(new MarkerOptions()
            .position(new LatLng(venues.get(i).getLocation().getLat(), venues.get(i).getLocation().getLng()))
            .title(venues.get(i).getName())
            .snippet(venues.get(i).getLocation().getAddress())
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker2)));

		}
	}
	
	class GymPlacesAdapter extends BaseAdapter
	{
		ArrayList<FVenue> venues;
		
		public GymPlacesAdapter(ArrayList<FVenue> venues)
		{
			this.venues = venues;
			
			if(venues == null)
				this.venues = new ArrayList<FVenue>();
		}
		
		@Override
		public int getCount() {
			return venues.size();
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
			TextView index;
			TextView name;
			TextView address;
			TextView ppl;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			ViewHolder vh;
			if (v == null)
			{
				v = LayoutInflater.from(getActivity()).inflate(R.layout.item_checkin_places, parent, false);
				
				vh = new ViewHolder();
				vh.index = (TextView)v.findViewById(R.id.index);
				vh.name = (TextView)v.findViewById(R.id.placename);
				vh.address = (TextView)v.findViewById(R.id.address);
				vh.ppl = (TextView)v.findViewById(R.id.ppl);
				
				v.setTag(vh);
			}
			else
				vh = (ViewHolder)v.getTag();
			
			int ppl = (int) (Math.round((Math.random()*10)));
			
			vh.index.setText(""+(position+1));
			vh.name.setText(venues.get(position).getName());
			vh.address.setText(venues.get(position).getLocation().getAddress());
			vh.ppl.setText(""+ppl );
			
			return v;
		}
		
	}
	
	OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			BaseCheckinActivity.placename =  ven.get(position).getName();
			BaseCheckinActivity.address =  ven.get(position).getLocation().getAddress();
			
			((BaseCheckinActivity)getActivity()).changeFragment(new CheckinFinalFragment());
		}
	};


}

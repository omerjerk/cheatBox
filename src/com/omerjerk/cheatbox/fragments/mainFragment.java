package com.omerjerk.cheatbox.fragments;

import com.omerjerk.cheatbox.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class mainFragment extends Fragment{
	
	public mainFragment() {
			setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// construct the RelativeLayout
		View v = new View(getActivity());
		v = inflater.inflate(R.layout.activity_main, null);		
		return v;
	}	
}
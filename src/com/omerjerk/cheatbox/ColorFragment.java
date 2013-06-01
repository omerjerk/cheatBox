package com.omerjerk.cheatbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorFragment extends Fragment {

	View v;


	public ColorFragment() {
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// construct the RelativeLayout
		
		v = inflater.inflate(R.layout.comin_soon, null);
		return v;
	}


}
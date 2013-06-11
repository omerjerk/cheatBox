package com.omerjerk.cheatbox.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.omerjerk.cheatbox.R;
import com.omerjerk.cheatbox.utils.copy;

public class templeRunFragment extends Fragment {
	View v ;
	
	public templeRunFragment() {
		setRetainInstance(true);
		}

	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	    // construct the RelativeLayout
	    v = inflater.inflate(R.layout.temple_run, null);	 
	    
	    Button patchButton2 = (Button) v.findViewById(R.id.patchButton2);
	    System.out.println("inside oncreate view");
	    patchButton2.setOnClickListener(new OnClickListener(){
	    	@Override
	    	public void onClick (View v){
	    		copy cp = new copy("/Android/data/com.imangi.templerun2/files", "gamedata.txt");
	    		boolean result = cp.task();
	    		if (result == false){
	    			Toast.makeText(getActivity(), "Shit Happened!\nMake sure your temple run is installed.", Toast.LENGTH_SHORT).show();
	    		}
	    	}
	    });
	    return v;
        }
    
    
}
package com.omerjerk.cheatbox.fragments;

import com.omerjerk.cheatbox.R;
import com.omerjerk.cheatbox.utils.advanceCheatsDialog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class templeRun1Fragment extends Fragment {
	
View v ;
	
	public templeRun1Fragment() {
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
	    		advanceCheatsDialog dialog = new advanceCheatsDialog();
	    		Bundle args = new Bundle();
	    		args.putInt("GAME_ID", 3);
	    		dialog.setArguments(args);
	    		dialog.show(getFragmentManager(), getTag());
	    	}
	    });
	    return v;
    }
}
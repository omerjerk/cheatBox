package com.omerjerk.cheatbox.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.omerjerk.cheatbox.R;
import com.omerjerk.cheatbox.utils.advanceCheatsDialog;

public class templeRunOzFragment extends Fragment {
	View v ;
	
	public templeRunOzFragment() {
		setRetainInstance(true);
		}

	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	    // construct the RelativeLayout
	    v = inflater.inflate(R.layout.temple_run_oz, null);	 
	    
	    Button patchButtonOz = (Button) v.findViewById(R.id.patchButtonOz);
	    System.out.println("inside oncreate view");
	    patchButtonOz.setOnClickListener(new OnClickListener(){
	    	@Override
	    	public void onClick (View v){
	    		advanceCheatsDialog dialog = new advanceCheatsDialog();
	    		Bundle args = new Bundle();
	    		args.putInt("GAME_ID", 2);
	    		dialog.setArguments(args);
	    		dialog.show(getFragmentManager(), getTag());
				}
	    });
	    return v;
        }
    
    
}
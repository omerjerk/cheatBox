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
				copy cp1 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "android_settings.oz");
				boolean result1 = cp1.task();
				copy cp2 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "stats.sav");
				boolean result2 = cp2.task();
				if(result1 == false || result2 == false){
					Toast.makeText(getActivity(), "Shit Happened!\nMake sure your Temple Run Oz is installed.", Toast.LENGTH_SHORT).show();
				}
	    	}
	    });
	    return v;
        }
    
    
}
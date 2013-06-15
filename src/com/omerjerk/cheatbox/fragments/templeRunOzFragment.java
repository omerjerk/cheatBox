package com.omerjerk.cheatbox.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.omerjerk.cheatbox.R;
import com.omerjerk.cheatbox.utils.advanceCheatsDialog;

public class templeRunOzFragment extends Fragment {
	View v ;
	private AdView adView;
	private static final String MY_AD_UNIT_ID = "a151bb16a45c7dc";
	
	public templeRunOzFragment() {
		setRetainInstance(true);
		}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	    // construct the RelativeLayout
	    v = inflater.inflate(R.layout.temple_run_oz, null);	 
	    
	    Button patchButtonOz = (Button) v.findViewById(R.id.patchButton);
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
	    
		 // Create the adView
	    adView = new AdView(getActivity(), AdSize.BANNER, MY_AD_UNIT_ID);

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout"
	    LinearLayout layout = (LinearLayout) v.findViewById(R.id.adLayout);

	    // Add the adView to it
	    layout.addView(adView);

	    // Initiate a generic request to load it with an ad
	    adView.loadAd(new AdRequest());
	    
	    return v;
     }    
    
    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
}
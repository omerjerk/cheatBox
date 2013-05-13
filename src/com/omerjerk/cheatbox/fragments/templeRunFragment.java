package com.omerjerk.cheatbox.fragments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.omerjerk.cheatbox.R;

public class templeRunFragment extends Fragment {
	View v ;
	
	public templeRunFragment() {
		setRetainInstance(true);
		}

	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
	    // construct the RelativeLayout
	    v = new View(getActivity());
	    v = inflater.inflate(R.layout.temple_run, null);	 
	    
	    Button patchButton = (Button) v.findViewById(R.id.patchButton);
	    
	    patchButton.setOnClickListener(new Button.OnClickListener(){
	    	@Override
	    	public void onClick (View v){
	    		File sdcard = Environment.getExternalStorageDirectory();
				File sourceOrig = new File(sdcard,"/Android/data/com.imangi.templerun2/files/gamedata.txt");
				
				
				File backupFolder = new File(sdcard, "/Android/data/com.imangi.templerun2/files/backup");
				
				
				if(!backupFolder.exists()){
					backupFolder.mkdirs();
				}
				
				File backupFile = new File (backupFolder, "/gamedata.txt");
				
				
			    byte[] buff = new byte[1024];
			    int read = 0;

			    try {
			    	InputStream inOrig = new FileInputStream(sourceOrig);
			    	OutputStream outOrig = new FileOutputStream(backupFile);
			    	while ((read = inOrig.read(buff)) > 0) {
				          outOrig.write(buff, 0, read);
				       }
			       InputStream inRaw = getResources().openRawResource(R.raw.gamedata);
			       FileOutputStream outPatched = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.imangi.templerun2/files/gamedata.txt");
			       while ((read = inRaw.read(buff)) > 0) {
			          outPatched.write(buff, 0, read);
			       }

			       outPatched.flush();
			       outPatched.close();
			       inRaw.close();
			       
			         
			         Toast.makeText(getActivity() , "Patched ...", Toast.LENGTH_SHORT).show();
			    } catch(Exception e) {
			    	Toast.makeText(getActivity() , "Shit Happened ! :(", Toast.LENGTH_SHORT).show();
			    }
	    	}
	    });
	    return v;
        }
    
    
}
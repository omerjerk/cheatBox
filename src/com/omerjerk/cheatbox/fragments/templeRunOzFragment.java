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

public class templeRunOzFragment extends Fragment {
	View v ;
	
	public templeRunOzFragment() {
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
				File sourceOrig1 = new File(sdcard,"/Android/data/com.disney.TempleRunOz.goo/files/android_settings.oz");
				File sourceOrig2 = new File(sdcard,"/Android/data/com.disney.TempleRunOz.goo/files/stats.sav");
				
				
				File backupFolder = new File(sdcard, "/Android/data/com.imangi.templerun2/files/backup");
				
				
				if(!backupFolder.exists()){
					backupFolder.mkdirs();
				}
				
				File backupFile1 = new File (backupFolder, "/gamedata.txt");
				File backupFile2 = new File (backupFolder, "/gamedata.txt");
				
				
			    byte[] buff1 = new byte[1024];
			    byte[] buff2 = new byte[1024];
			    int read1 = 0;
			    int read2 = 0;

			    try {
			    	InputStream inOrig1 = new FileInputStream(sourceOrig1);
			    	InputStream inOrig2 = new FileInputStream(sourceOrig2);
			    	OutputStream outOrig1 = new FileOutputStream(backupFile1);
			    	OutputStream outOrig2 = new FileOutputStream(backupFile2);
			    	while ((read1 = inOrig1.read(buff1)) > 0) {
				          outOrig1.write(buff1, 0, read1);
				       }
			    	while ((read2 = inOrig2.read(buff2)) > 0) {
				          outOrig2.write(buff2, 0, read2);
				       }
			       InputStream inRaw1 = getResources().openRawResource(R.raw.android_settings);
			       InputStream inRaw2 = getResources().openRawResource(R.raw.stats);
			       FileOutputStream outPatched1 = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.disney.TempleRunOz.goo/files/android_settings.oz");
			       while ((read1 = inRaw1.read(buff1)) > 0) {
			          outPatched1.write(buff1, 0, read1);
			       }

			       outPatched1.flush();
			       outPatched1.close();
			       inRaw1.close();
			       
			       FileOutputStream outPatched2 = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.disney.TempleRunOz.goo/files/stats.sav");
			       while ((read2 = inRaw2.read(buff2)) > 0) {
			          outPatched2.write(buff2, 0, read2);
			       }

			       outPatched2.flush();
			       outPatched2.close();
			       inRaw2.close();
			       
			         
			         Toast.makeText(getActivity() , "Patched ...", Toast.LENGTH_SHORT).show();
			    } catch(Exception e) {
			    	Toast.makeText(getActivity() , "Shit Happened ! :(  \nAnd make sure your Temple Run is installed!", Toast.LENGTH_SHORT).show();
			    }
	    	}
	    });
	    return v;
        }
    
    
}
package com.omerjerk.cheatbox.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.os.Environment;

import com.omerjerk.cheatbox.R;

public class copy{ 
	
	File sdcard = Environment.getExternalStorageDirectory();
	
	String input, filename;
	int tempHack;
	Context context;
	public copy(String in, String fname, int thack, Context c){
		this.input =in; 
		this.filename = fname;
		this.tempHack = thack;
		this.context = c;
	}
		
	public boolean task(){
		File sourceOrg = new File(new File(sdcard, input), "/" + filename);
		File backupFolder = new File( new File(sdcard, input), "/backup");
		
		if(!backupFolder.exists()){
			backupFolder.mkdirs();
		}
		
		File backupFile = new File (backupFolder, "/" + filename);
		
		byte[] buff = new byte[1024];
	    int read = 0;
	    
	    InputStream inOrig = null;
	    OutputStream outOrig = null;
	    try {
	    	inOrig = new FileInputStream(sourceOrg);
	    	outOrig = new FileOutputStream(backupFile);
	    	while ((read = inOrig.read(buff)) > 0) {
		          outOrig.write(buff, 0, read);
		       }
	    	InputStream inRaw = null;
	    	FileOutputStream outPatched = null;
	    	switch (tempHack){
	    	case 1:
	    		inRaw = context.getResources().openRawResource(R.raw.gamedata);
	    		outPatched = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.imangi.templerun2/files/gamedata.txt"); 
	    		break;
	    	case 2:
	    		inRaw = context.getResources().openRawResource(R.raw.android_settings);
	    		outPatched = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.disney.TempleRunOz.goo/files/android_settings.oz"); 
	    		break;
	    	case 3:
	    		inRaw = context.getResources().openRawResource(R.raw.stats);
	    		outPatched = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.disney.TempleRunOz.goo/files/stats.sav"); 
	    		break;
	    	case 4:
	    		inRaw = context.getResources().openRawResource(R.raw.recordmanager);
	    		outPatched = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.imangi.templerun/files/recordmanager.dat"); 
	    		break;
	    	}
	       
	       while ((read = inRaw.read(buff)) > 0) {
	          outPatched.write(buff, 0, read);
	       }
	       
	       inOrig.close();
	       outOrig.close();
	       inRaw.close();
	       outPatched.close();
	       return true;
	    } catch (IOException e){
	        return false;
	    }
	}
	
}
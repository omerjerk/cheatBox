package com.omerjerk.cheatbox.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class advanceCheatsDialog extends DialogFragment {
	
	 Context c;
	 SharedPreferences settings;
	 @Override
	 public Dialog onCreateDialog(Bundle savedInstanceState) {
		 //Extracting the arguments
		 final int gameID = getArguments().getInt("GAME_ID");
		 
	     // Use the Builder class for convenient dialog construction
	     AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	     c = getActivity(); // Context object to use at various places
	     settings = c.getSharedPreferences("SETTINGS_MAIN", 0);
	     final Boolean mainRun = settings.getBoolean("MAIN_RUN", false);
	     builder.setMessage("Advance Patching")
	            .setPositiveButton("Patch", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    // PATCH ZE GAME
	                	if(mainRun == false){
	                		patchTask(gameID);
	                	} else {
	                		Toast.makeText(c, "Your game is already patched. Please restore before patching again.", Toast.LENGTH_SHORT).show();
	                	}
	                }
	            })
	            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    // User cancelled the dialog
	                }
	            })
	            .setNeutralButton("Restore", new DialogInterface.OnClickListener(){
	            	public void onClick(DialogInterface dialog, int id){
	            		if(mainRun == true){
	            			restoreTask(gameID);
	            		} else {
	            			Toast.makeText(c, "Please patch atleast once.", Toast.LENGTH_LONG).show();
	            		}
	            	}	            	
	            });
	     // Create the AlertDialog object and return it
	     return builder.create();
	 }
	 copy cp; boolean result = true;
	 private void patchTask(int i){
		 
		 switch(i){
		 case 1:
			 cp = new copy("/Android/data/com.imangi.templerun2/files", "gamedata.txt", 1, c); 
	    	 result = cp.task();
	    	 	if (result == true){
	    			Toast.makeText(getActivity(), "Patched ...   :D", Toast.LENGTH_SHORT).show();
	    		} else {
	    			Toast.makeText(getActivity(), "Shit Happened!\nMake sure your temple run is installed.", Toast.LENGTH_SHORT).show();
	    		} break;
		 case 2:
			 cp = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "android_settings.oz", 2, c);
			 result = cp.task();
			 copy cp1 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "stats.sav", 3, c);
			 boolean result2 = cp1.task();
			 if(result == false || result2 == false){
			 	Toast.makeText(getActivity(), "Shit Happened!\nMake sure your Temple Run Oz is installed.", Toast.LENGTH_SHORT).show();
			 } break;
		 case 3:
			 cp = new copy("/Android/data/com.imangi.templerun/files", "recordmanager.dat", 4, c);
			 result = cp.task();
		 }
	 }	 
	 
	 private void restoreTask(int i){
		 switch(i){
		 case 1:
			 cp = new copy("/Android/data/com.imangi.templerun2/files/backup", "gamedata.txt", 5, c);
			 result = cp.task();
			 if(result == false){
				 unableToRestore();
			 }
			 break;
		 case 2:
			 cp = new copy("/Android/data/com.disney.TempleRunOz.goo/files/backup", "android_settings.oz", 5, c);
			 result = cp.task();
			 copy cp1 = new copy("/Android/data/com.disney.TempleRunOz.goo/files/backup", "stats.sav", 5, c);
			 boolean result1 = cp1.task();
			 if(result == false || result1 == false){
				 unableToRestore();
			 }
			 break;
		 case 3:
			 cp = new copy("/Android/data/com.imangi.templerun/files", "recordmanager.dat", 5, c);
			 result = cp.task();
			 if(result == false){
				 unableToRestore();
			 }
		 }
	 }
	 
	 private void unableToRestore(){
		 Toast.makeText(c, "Unable to restore.", Toast.LENGTH_SHORT).show();
	 }
}
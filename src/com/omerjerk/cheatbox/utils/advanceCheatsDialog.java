package com.omerjerk.cheatbox.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class advanceCheatsDialog extends DialogFragment {
	
	 Context c;
	 @Override
	 public Dialog onCreateDialog(Bundle savedInstanceState) {
		 //Extracting the arguments
		 final int gameID = getArguments().getInt("GAME_ID");
	     // Use the Builder class for convenient dialog construction
	     AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	     c = getActivity();
	     builder.setMessage("Advance Patches")
	            .setPositiveButton("Patch", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    // PATCH ZE GAME
	                	patchTask(gameID);
	                }
	            })
	            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    // User cancelled the dialog
	                }
	            });
	     // Create the AlertDialog object and return it
	     return builder.create();
	 }
	 
	 private void patchTask(int i){
		 copy cp; boolean result = true;
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
			 copy cp2 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "stats.sav", 3, c);
			 boolean result2 = cp2.task();
			 if(result == false || result2 == false){
			 	Toast.makeText(getActivity(), "Shit Happened!\nMake sure your Temple Run Oz is installed.", Toast.LENGTH_SHORT).show();
			 } break;
		 case 3:
			 cp = new copy("/Android/data/com.imangi.templerun/files", "recordmanager.dat", 4, c);
			 result = cp.task();
		 }
	 }
}
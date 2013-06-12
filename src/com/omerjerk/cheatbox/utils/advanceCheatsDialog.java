package com.omerjerk.cheatbox.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class advanceCheatsDialog extends DialogFragment {
	
	 @Override
	 public Dialog onCreateDialog(Bundle savedInstanceState) {
		 //Extracting the arguments
		 final int gameID = getArguments().getInt("GAME_ID");
	     // Use the Builder class for convenient dialog construction
	     AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	     builder.setMessage("Hello world")
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
		 switch(i){
		 case 1:
			 copy cp = new copy("/Android/data/com.imangi.templerun2/files", "gamedata.txt");
	    	 boolean result = cp.task();
	    	 	if (result == true){
	    			Toast.makeText(getActivity(), "Patched ...   :D", Toast.LENGTH_SHORT).show();
	    		} else {
	    			Toast.makeText(getActivity(), "Shit Happened!\nMake sure your temple run is installed.", Toast.LENGTH_SHORT).show();
	    		};
		 case 2:
			 copy cp1 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "android_settings.oz");
			 boolean result1 = cp1.task();
			 copy cp2 = new copy("/Android/data/com.disney.TempleRunOz.goo/files", "stats.sav");
			 boolean result2 = cp2.task();
			 if(result1 == false || result2 == false){
			 	Toast.makeText(getActivity(), "Shit Happened!\nMake sure your Temple Run Oz is installed.", Toast.LENGTH_SHORT).show();
			 }
		 }
	 }
}
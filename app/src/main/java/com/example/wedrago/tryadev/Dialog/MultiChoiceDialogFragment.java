package com.example.wedrago.tryadev.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Liu Weilong on 2/11/15.
 */
public class MultiChoiceDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ArrayList<String> mSelectedItem = new ArrayList<>();
        final String[] colors = {"Red", "Yello", "Blue"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a color");
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    mSelectedItem.add(colors[which]);
                    Log.d("DEBUG", "Checked" + colors[which]);
                } else if (mSelectedItem.contains(colors[which])) {
                    mSelectedItem.remove(colors[which]);
                    Log.d("DEBUG", colors[which]);
                }
            }
        });
        return builder.create();
    }
}

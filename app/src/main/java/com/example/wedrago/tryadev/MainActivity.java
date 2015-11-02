package com.example.wedrago.tryadev;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.wedrago.tryadev.Dialog.CustomViewDialogFragment;
import com.example.wedrago.tryadev.Dialog.FireMisslesDialogFragment;
import com.example.wedrago.tryadev.Dialog.MultiChoiceDialogFragment;
import com.example.wedrago.tryadev.Dialog.SetItemsDialogFragment;
import com.example.wedrago.tryadev.ProcessandThread.ProcessandThreadActivity;

public class MainActivity extends AppCompatActivity implements FireMisslesDialogFragment.NoticeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Process and Thread
        Button btnProcessandThread = (Button) findViewById(R.id.btnPorcessandThread);
        btnProcessandThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProcessandThreadActivity.class);
                startActivity(intent);
            }
        });

        // Dialog
        Button btnDialog = (Button) findViewById(R.id.btnCreateDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMisslesDialogFragment dialog = new FireMisslesDialogFragment();
//                SetItemsDialogFragment dialog = new SetItemsDialogFragment();
//                MultiChoiceDialogFragment dialog = new MultiChoiceDialogFragment();
//                CustomViewDialogFragment dialog = new CustomViewDialogFragment();
                dialog.show(getFragmentManager(), "Dialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Snackbar.make(findViewById(R.id.root_view), "Positive clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Snackbar.make(findViewById(R.id.root_view), "Negative clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

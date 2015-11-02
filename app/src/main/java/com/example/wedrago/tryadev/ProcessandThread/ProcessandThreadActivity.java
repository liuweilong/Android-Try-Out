package com.example.wedrago.tryadev.ProcessandThread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wedrago.tryadev.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProcessandThreadActivity extends AppCompatActivity {

    TextView processRestult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processand_thread);
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

        processRestult = (TextView) findViewById(R.id.textViewProcessResult);

        Button startRequest = (Button) findViewById(R.id.btnStartRequest);

        startRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetRequestTask().execute("http://www.google.com/search?q=httpClient");
            }
        });
    }

    /**
     * Created by Liu Weilong on 2/11/15.
     */
    public class GetRequestTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                String url = "http://www.google.com/search?q=mkyong";

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                //add request header
                con.setRequestProperty("User-Agent", "Mozilla/5.0");

                int responseCode = con.getResponseCode();
                Log.d("DEBUG", "Sending 'GET' request to URL : " + url);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } catch (Exception e) {
                Log.e("ERROR", "Failed to make request");
                return "Falied";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            processRestult.setText(s);
        }
    }
}

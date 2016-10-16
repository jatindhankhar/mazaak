package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.Javajokes;
import com.udacity.gradle.JokeActivity;


public class MainActivity extends ActionBarActivity {
    String result = "";//Holds result
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void tellJoke(){


        //Thanks http://stackoverflow.com/questions/12575068/how-to-get-the-result-of-onpostexecute-to-main-activity-because-asynctask-is-a

        final JokeEndPointsAsyncTask asyncTask = (JokeEndPointsAsyncTask) new JokeEndPointsAsyncTask(new JokeEndPointsAsyncTask.AsyncResponse() {

            @Override
            public void processResponse(String output) {
                Log.d("Yolopad","Response from server is " + output);
                ((ProgressBar)findViewById(R.id.progress_bar)).setVisibility(View.VISIBLE);
                result = output;
            //    Log.d("Yolopad","Output is " + result);

            }


        }).execute();


      //  Log.d("Yolopad","Joke is " +result);
        if(! result.isEmpty()){
            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE_KEY, result);
            startActivity(intent);
        }
        else
        {
        //    Log.d("Yolopad","Joke is " +result);
            ((ProgressBar)findViewById(R.id.progress_bar)).setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "Failed to get data", Toast.LENGTH_SHORT).show();
        }
    }



}

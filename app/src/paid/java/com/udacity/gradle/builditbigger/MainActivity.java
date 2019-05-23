package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.jokedisplayer.MainJokeActivity;


public class MainActivity extends AppCompatActivity implements OnTaskCompleted{

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
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

    public void tellJoke(View view) {
        loadDataWithProgressBar();
    }

    private void loadDataWithProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        //when the ad is closed we fetch the joke
        new EndpointsAsyncTask(MainActivity.this).execute(null, null);
    }

    @Override
    public void onTaskCompleted(String result) {
        Intent myIntent = new Intent(this, MainJokeActivity.class);
        myIntent.putExtra(Intent.EXTRA_TEXT, result);
        mProgressBar.setVisibility(View.GONE);
        startActivity(myIntent);
    }
}

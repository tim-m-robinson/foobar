package org.tmr.telehealth;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import org.tmr.telehealth.dao.Event;
import org.tmr.telehealth.dao.TestDataFactory;

import java.io.IOException;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ( !((TeleHealthApplication ) getApplication()).loggedIn()) {
            Intent loginScreen = new Intent(this, LoginActivity.class);
            loginScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(loginScreen);
        }

        ImageButton askBtn = (ImageButton) findViewById(R.id.askButton);
        askBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nhs.uk/Service-Search/Performance/Search"));
                //Intent intent = new Intent(MainActivity.this, AskActivity.class);
                startActivity(intent);

            }
        });

        ImageButton calBtn = (ImageButton) findViewById(R.id.calButton);
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalActivity.class);
                startActivity(intent);

            }
        });

        ImageButton apptBtn = (ImageButton) findViewById(R.id.apptButton);
        apptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ApptActivity.class);
                startActivity(intent);

            }
        });

        ImageButton monitorBtn = (ImageButton) findViewById(R.id.monitorButton);
        monitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MonitorActivity.class);
                startActivity(intent);

            }
        });

        ImageButton msgBtn = (ImageButton) findViewById(R.id.smsButton);
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MsgActivity.class);
                startActivity(intent);

            }
        });
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
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
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
/*
    @Override
    public void onBackPressed() {
        // Quit app
        finish();
    }
    */
}

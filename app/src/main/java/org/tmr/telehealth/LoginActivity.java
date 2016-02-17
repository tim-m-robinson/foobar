package org.tmr.telehealth;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
//import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText pin = (EditText) findViewById(R.id.pin);
        pin.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
               if( s.length() > 3 ) login();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        /*
        Button loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                login();
            }
        });
        */
    }

    private void login() {

        EditText pinText = (EditText) findViewById(R.id.pin);
        if(pinText.getText().toString().equals("1111")) {
            ((TeleHealthApplication ) getApplication()).setLoggedIn(true);
            Intent mainScreen = new Intent(LoginActivity.this, MainActivity.class);
            mainScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mainScreen);
        } else {
            Toast.makeText(getBaseContext(), "PIN incorrect", Toast.LENGTH_LONG).show();
            pinText.getText().clear();
        }


    }
/*
    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }
*/
}

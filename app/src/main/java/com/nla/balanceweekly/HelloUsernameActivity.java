package com.nla.balanceweekly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;



public class HelloUsernameActivity extends Activity {

    private TextView messageText;
    public String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        messageText = findViewById(R.id.message_text);

        Bundle arguments = getIntent().getExtras();
        username = arguments.get("username").toString();

        String message = getString(R.string.hello_username, username);
        messageText.setText(message);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), General.class));
            }
        }, 1500);



    }


}
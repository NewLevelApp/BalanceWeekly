package com.nla.balanceweekly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etText;
    Button btnActMain, btnLoad;
    SharedPreferences sPref;

    public final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_main);
       etText = (EditText)findViewById(R.id.stringName);

       btnActMain = (Button)findViewById(R.id.btnActMain);
       btnActMain.setOnClickListener(this);

       loadText();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnActMain:
                saveText();
                loadText();
                break;
            default:
                break;
        }


    }


    private void saveText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
//        Toast.makeText(MainActivity.this, "Text saved", Toast.LENGTH_SHORT).show();


    }


    private void loadText() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);

//        Toast.makeText(MainActivity.this,  savedText, Toast.LENGTH_SHORT).show();

        if(savedText != ""){

            Intent intent = new Intent(MainActivity.this, HelloUsernameActivity.class);
            intent.putExtra("username",savedText);
            startActivity(intent);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}







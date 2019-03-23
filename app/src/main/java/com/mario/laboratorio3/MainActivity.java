package com.mario.laboratorio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.mario.laboratorio3.utils.Login;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    private Button butt_Send;

    private EditText name,pass,email,gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butt_Send = findViewById(R.id.Button_send);
        name = findViewById(R.id.ins_name);
        pass = findViewById(R.id.ins_pass);
        email = findViewById(R.id.ins_email);
        gender = findViewById(R.id.ins_gender);

        butt_Send.setOnClickListener(v->{
            Intent mIntent = new Intent(MainActivity.this,Share.class);

            mIntent.putExtra(Login.NAME_KEY,name.getText().toString());
            mIntent.putExtra(Login.PASSWORD_KEY, pass.getText().toString());
            mIntent.putExtra(Login.EMAIL_KEY, email.getText().toString());
            mIntent.putExtra(Login.GENDER_KEY, gender.getText().toString());

            startActivity(mIntent);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"on pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"on Destroy");
    }
}

package com.mario.laboratorio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mario.laboratorio3.utils.Login;

public class Share extends AppCompatActivity {

    private TextView name, pass, email, gender;

    private Button btt_Share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        btt_Share = findViewById(R.id.btt_Share);

        name = findViewById(R.id.tv_name);
        pass = findViewById(R.id.tv_pass);
        email = findViewById(R.id.tv_email);
        gender = findViewById(R.id.tv_gender);

        Intent mIntent = this.getIntent();

        if (mIntent!=null) {
            name.setText(mIntent.getStringExtra(Login.NAME_KEY));
            pass.setText(mIntent.getStringExtra(Login.PASSWORD_KEY));
            email.setText(mIntent.getStringExtra(Login.EMAIL_KEY));
            gender.setText(mIntent.getStringExtra(Login.GENDER_KEY));
        }

        btt_Share.setOnClickListener(v -> {
            Intent Send_Intent = new Intent();

            Send_Intent.setAction(Intent.ACTION_SEND);
            Send_Intent.setType("text/plain");

            Send_Intent.putExtra(Intent.EXTRA_TEXT,name.getText().toString()+" "+pass.getText().toString()+" "+email.getText().toString()+" "+gender.getText().toString());

            startActivity(Send_Intent);
        });
    }
}

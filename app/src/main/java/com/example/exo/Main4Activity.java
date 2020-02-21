package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        this.setTitle("Détails de l'utilisateur");
        if (bundle != null) {
            TextView fn = (TextView) findViewById(R.id.txt_user_fn);
            TextView ln = (TextView) findViewById(R.id.user_ln);
            TextView tel = (TextView) findViewById(R.id.user_phone);
            TextView ugender = (TextView) findViewById(R.id.user_gender);

            String first_name =  bundle.getString("user_first_name");
            String last_name =  bundle.getString("user_last_name");
            String gender =  bundle.getString("user_sexe");
            String phone =  bundle.getString("user_phone");

            fn.setText(first_name);
            ln.setText(last_name);
            tel.setText(phone);
            ugender.setText(gender);

        }
    }
}

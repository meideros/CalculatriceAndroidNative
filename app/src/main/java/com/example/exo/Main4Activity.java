package com.example.exo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
            final TextView tel = (TextView) findViewById(R.id.user_phone);
            TextView ugender = (TextView) findViewById(R.id.user_gender);
            Button btn = (Button) findViewById(R.id.btn_call);

            String first_name = bundle.getString("user_first_name");
            String last_name = bundle.getString("user_last_name");
            String gender = bundle.getString("user_sexe");
            String phone = bundle.getString("user_phone");

            fn.setText(first_name);
            ln.setText(last_name);
            tel.setText(phone);
            ugender.setText(gender);

            btn.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:96346856"));
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        return;
                    }
                    startActivity(callIntent);
                }
            });


        }
    }


}

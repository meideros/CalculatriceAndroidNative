package com.example.exo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import models.User;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.setTitle("Liste des utilisateurs");

        List<User> UserList = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listUser) ;
        UserList.add(new User("GNACADJA", "Lucas", 25,"Masculin","96346856"));
        UserList.add(new User("ADELEKE", "Kismath", 21,"Féminin","96192019"));
        UserList.add(new User("TOLOGNON", "Robert", 20,"Masculin","61720976"));
        UserList.add(new User("ASSOGBA", "Danielle", 19,"Féminin","67712006"));
        UserList.add(new User("AKPLOGAN", "Michelle", 32,"Féminin","67712006"));

        listView.setAdapter(new Adapter(this,UserList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User item = (User) parent.getItemAtPosition(position);
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                intent.putExtra("user_first_name", item.getFirst_name());
                intent.putExtra("user_last_name", item.getLast_name());
                intent.putExtra("user_phone", item.getPhone());
                intent.putExtra("user_sexe", item.getSexe());

                startActivity(intent);
            }
        });
    }
}

package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txtname,txtage,txtphone,txtheight;
    Button btnInsert;
    FirebaseDatabase database;
    DatabaseReference reff;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname = (EditText) findViewById(R.id.name);
        txtage = (EditText) findViewById(R.id.age);
        txtheight = (EditText) findViewById(R.id.height);
        txtphone = (EditText) findViewById(R.id.phone);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int agea = Integer.parseInt(txtage.getText().toString().trim());
                Float hit = Float.parseFloat((txtheight.getText().toString().trim()));
                Long phn = Long.parseLong((txtphone).getText().toString().trim());

                member.setName(txtname.getText().toString().trim());
                member.setAge(agea);
                member.setHt(hit);
                member.setPh(phn);

                reff.push().setValue(member);
                Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();
            }
        });

    }


}

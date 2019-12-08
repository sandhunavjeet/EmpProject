package com.example.empproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText name, email, phone;
    Button Insert;
    FloatingActionButton floatingActionButton;
    FirebaseDatabase database;
    DatabaseReference ref;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            name = (EditText)findViewById(R.id.name);
            email = (EditText)findViewById(R.id.email);
            phone = (EditText)findViewById(R.id.phone);
            Insert = (Button)findViewById(R.id.btnInsert);
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Person");
            person = new Person();
            floatingActionButton = findViewById(R.id.floatingActionButton);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent next = new Intent(MainActivity.this,ViewEmpActivity.class);
                }
            });
            Insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    person.setName(name.getText().toString());
                    person.setEmail(email.getText().toString());
                    person.setPhone(phone.getText().toString());
                    ref.push().setValue(person);
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                }


            });
    }

}


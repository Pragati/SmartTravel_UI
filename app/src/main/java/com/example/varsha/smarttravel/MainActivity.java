package com.example.varsha.smarttravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Varsha on 4/2/2017.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "AndroidBash";
    private Firebase mRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRef = new Firebase("https://smarttravel-edfa8.firebaseio.com/Users");
        mAuth = FirebaseAuth.getInstance();

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("American Cuisine");
        categories.add("Chinese Cuisine");
        categories.add("Indian Cuisine");
        categories.add("Italian Cuisine");
        categories.add("Mediterranean Cuisine");
        categories.add("Mexican Cuisine");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Get the uid for the currently logged in User from intent data passed to this activity
        //String uid = getIntent().getExtras().getString("user_id");

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        /* if (id == R.id.action_chat) {
            chatMessenger();
        }*/
        if (id == R.id.action_logout) {
            mAuth.signOut();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void chatMessenger() {

        Intent i = new Intent(MainActivity.this, ChatMessenger.class);
        startActivity(i);
    }*/

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();


       /* if(item=="American Cuisine")
        else if(item=="Chinese Cuisine")
        else if(item=="Indian Cuisine")
        else if(item=="Italian Cuisine")
        else if(item=="Mediterranean Cuisine")
        else (item=="Mexican Cuisine")*/


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show(); //to be changed in future
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


}

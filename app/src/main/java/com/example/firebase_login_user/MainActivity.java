package com.example.firebase_login_user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    TextView email;
    FirebaseAuth fAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //phone = findViewById(R.id.profilePhone);
       // fullName = findViewById(R.id.profileName);
        email   = findViewById(R.id.profileEmail);

        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        String emailUser=fAuth.getInstance().getCurrentUser().getEmail().toString();
        email.setText(emailUser);


      //  Log.i("--------------",emailUser);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
package com.example.company;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText password;
    private EditText fullname;
    private EditText confirmpassword;
    private Button registerr;
    private Button login2;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        registerr = (Button) findViewById(R.id.register);
        fullname = (EditText) findViewById(R.id.fullname);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        registerr.setOnClickListener(this);
        //  login2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register: {
                Log.i("joly",email.getText().toString() + password.getText().toString());
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent3 = new Intent(RegistrationActivity.this, ListActivity.class);
                            startActivity(intent3);
                        } else {
                            Log.d("ERROR", task.getException().toString());


                        }
                    }

                });
            }
        }
    }
}
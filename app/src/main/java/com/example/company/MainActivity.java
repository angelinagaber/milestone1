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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Login ;
    private EditText Password;
    private EditText email;
    private Button regestration;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = (Button)findViewById(R.id.login);
        email =(EditText) findViewById(R.id.emails);
        Password =(EditText) findViewById(R.id.editTextpasswordddddd);
        regestration = (Button)findViewById(R.id.register1);
        FirebaseApp.initializeApp(this);
       firebaseAuth=FirebaseAuth.getInstance();
//        FirebaseUser user=firebaseAuth.getCurrentUser();


//        if(user!=null){
//            finish();
//            startActivity(new Intent(MainActivity.this,ListActivity.class));
//
//        }
        Login.setOnClickListener(this);
        regestration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            if(v.getId()== R.id.login) {
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Intent intent1 = new Intent(MainActivity.this, ListActivity.class);
                            startActivity(intent1);
                        } else {
                            Log.d("error", task.getException().toString());

                        }

                    }
                });
            }

       else if(v.getId()== R.id.register1)  {
            Intent intent4 = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent4);



       }

        }
    }

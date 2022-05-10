package com.firebase.kiemtrathuchanh;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        EditText email = findViewById(R.id.regis_email);
        EditText password = findViewById(R.id.regis_pass);
        EditText repass = findViewById(R.id.regis_repass);
        Button btnRe = findViewById(R.id.btnregis);
        TextView txtLogin = findViewById(R.id.txtlogin);

        if(password.getText().toString().equalsIgnoreCase(repass.getText().toString())){

            btnRe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    createAccount(email.getText().toString(),password.getText().toString());

                }
            });
        }else{
            Toast.makeText(Register.this, "Password ko trung failed.",
                    Toast.LENGTH_SHORT).show();
        }


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });



    }

    public void createAccount(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i  = new Intent(getBaseContext(),MainActivity.class);
                            startActivity(i);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    private void updateUI(FirebaseUser user) {
        if(user != null){
            Toast.makeText(Register.this, "createUserWithEmail:success",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(Register.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }
    }





}
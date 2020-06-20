package com.example.studentinfo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Signup_Activity extends AppCompatActivity {

    EditText full_name,user_name,email,password,confirm_password;
    TextView signinlink;
    Button signup;
    ProgressBar progressBar;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        full_name=findViewById(R.id.signup_fullname_id);
        user_name=findViewById(R.id.signup_usrname_id);
        email=findViewById(R.id.signup_email_id);
        password=findViewById(R.id.signup_password_id);
        confirm_password=findViewById(R.id.signup_confirmpassword_id);
        password=findViewById(R.id.signup_password_id);
        signinlink=findViewById(R.id.login_link_id);
        signup=findViewById(R.id.signup_button_id);
        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.signUp_progressbar_id);
        databaseReference= FirebaseDatabase.getInstance().getReference("Authentication");

        signinlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup_Activity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname=full_name.getText().toString();
                String username=user_name.getText().toString();
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                String confirm_pass=confirm_password.getText().toString();

                if(fullname.isEmpty())
                {
                    full_name.setError("Enter Full Name");
                    full_name.requestFocus();
                    return;
                }
                if(username.isEmpty())
                {
                    user_name.setError("Enter Username");
                    user_name.requestFocus();
                    return;
                }
                if(mail.isEmpty())
                {
                    email.setError("Enter Email");
                    email.requestFocus();
                    return;
                }
                if(pass.isEmpty())
                {
                    password.setError("Enter Password");
                    password.requestFocus();
                    return;
                }
                if(confirm_pass.isEmpty())
                {
                    confirm_password.setError("Confirm Password");
                    confirm_password.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    email.setError("Enter a valid Email");
                    email.requestFocus();
                    return;
                }
                else {
                    try{
                        Authentication authentication=new Authentication(fullname,username,mail,pass,confirm_pass);
                        databaseReference.child(fullname).setValue(authentication);
                    }catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                    }
                }


                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Account is created successfully.",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(Signup_Activity.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("passkey","user");
                            startActivity(intent);
                            finish();
                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(getApplicationContext(),"User is already Registered.",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Error "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }

                    }
                });
            }
        });
    }
}

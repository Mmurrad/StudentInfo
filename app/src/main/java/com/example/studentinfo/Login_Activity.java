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

public class Login_Activity extends AppCompatActivity {

    private Button loginbutton;
    EditText email,password;
    TextView signuplink;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        mAuth = FirebaseAuth.getInstance();

        loginbutton=findViewById(R.id.login_id);
        signuplink=findViewById(R.id.signup_link_id);
        email=findViewById(R.id.login_email_id);
        password=findViewById(R.id.login_password_id);
        progressBar=findViewById(R.id.login_proressbar_id);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mail=email.getText().toString();
                String pass=password.getText().toString();
                if(mail.isEmpty())
                {
                    email.setError("Enter Email.");
                    email.requestFocus();
                    return;
                }
                if(pass.isEmpty())
                {
                    password.setError("Enter Password.");
                    password.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                {
                    email.setError("Enter a valid Email.");
                    email.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                if(pass.equals("allah")&&mail.equals("saydulakbarmurad@gmail.com"))
                {
                    Intent intent=new Intent(Login_Activity.this,MainActivity.class);
                    progressBar.setVisibility(View.GONE);
                    intent.putExtra("passkey","admin");
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
                else {
                    mAuth.signInWithEmailAndPassword(mail, pass)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Intent intent=new Intent(Login_Activity.this,MainActivity.class);
                                intent.putExtra("passkey","user");
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login_Activity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }

            }
        });
        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Activity.this,Signup_Activity.class);
                startActivity(intent);
            }
        });
    }
}

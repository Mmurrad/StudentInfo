package com.example.studentinfo;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button notice_board,teacher,students,parents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notice_board=findViewById(R.id.notice_board_id);
        teacher=findViewById(R.id.teacher_id);
        students=findViewById(R.id.student_id);
        parents=findViewById(R.id.parents_id);
        Bundle bundle=getIntent().getExtras();
        final String passkey=bundle.getString("passkey");

        notice_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passkey.equals("admin"))
                {
                    Intent intent=new Intent(MainActivity.this,Notice_board_Activity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(MainActivity.this,ListOfPdf_Activity.class);
                    intent.putExtra("key","showdata");
                    startActivity(intent);
                }

            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(passkey.equals("admin"))
                    {
                        Intent intent=new Intent(MainActivity.this,Teacher_Activity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"You Are Not Admin.",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                }

            }
        });
        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Student_HomePage.class);
                startActivity(intent);
            }
        });
        parents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                View view1=inflater.inflate(R.layout.assurance_guardian,null);
                builder.setView(view1);

                final TextView no=view1.findViewById(R.id.no_id);
                final TextView yes=view1.findViewById(R.id.yes_id);

                builder.setTitle("Are You Guardian ?");
                final AlertDialog alertDialog=builder.create();

                alertDialog.show();

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,ParentsHomePage.class);
                        startActivity(intent);
                        alertDialog.dismiss();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }
}

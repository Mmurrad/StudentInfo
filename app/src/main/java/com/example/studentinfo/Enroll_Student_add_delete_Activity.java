package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class Enroll_Student_add_delete_Activity extends AppCompatActivity {

    CardView add_details,update_details,delete_details,show_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll__student_add_delete_);

        add_details=findViewById(R.id.student_add_details_id);
        //update_details=findViewById(R.id.student_update_data_id);
        //delete_details=findViewById(R.id.student_delete_data_id);
        show_details=findViewById(R.id.student_show_data_id);

        Bundle bundle=getIntent().getExtras();
        Bundle bundle1=getIntent().getExtras();

        final String passvalue=bundle.getString("term");
        final String passkey=bundle1.getString("student");


        add_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passkey.equals("enroll_s"))
                {
                    try{
                        Intent intent=new Intent(Enroll_Student_add_delete_Activity.this,Student_enroll_add_data_Activity.class);
                        startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                    }

                }

                else if(passkey.equals("result"))
                {
                    try{
                        Intent intent=new Intent(Enroll_Student_add_delete_Activity.this,AddResult_Activity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        show_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passkey.equals("enroll_s"))
                {
                    Intent intent=new Intent(Enroll_Student_add_delete_Activity.this,Show_student_details_recyclerview.class);
                    if (passvalue.equals("first"))
                    {
                        intent.putExtra("term","first");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("second"))
                    {
                        intent.putExtra("term","second");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("third"))
                    {
                        intent.putExtra("term","third");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("fourth"))
                    {
                        intent.putExtra("term","fourth");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("fifth"))
                    {
                        intent.putExtra("term","fifth");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("six"))
                    {
                        intent.putExtra("term","six");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("seven"))
                    {
                        intent.putExtra("term","seven");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("eight"))
                    {
                        intent.putExtra("term","eight");
                        startActivity(intent);
                    }
                }


                else if(passkey.equals("result"))
                {
                    Intent intent=new Intent(Enroll_Student_add_delete_Activity.this,ShowResultActivity.class);
                    if (passvalue.equals("first"))
                    {
                        intent.putExtra("result","first");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("second"))
                    {
                        intent.putExtra("result","second");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("third"))
                    {
                        intent.putExtra("result","third");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("fourth"))
                    {
                        intent.putExtra("result","fourth");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("fifth"))
                    {
                        intent.putExtra("result","fifth");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("six"))
                    {
                        intent.putExtra("result","six");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("seven"))
                    {
                        intent.putExtra("result","seven");
                        startActivity(intent);
                    }
                    else if(passvalue.equals("eight"))
                    {
                        intent.putExtra("result","eight");
                        startActivity(intent);
                    }
                }
            }
        });

    }
}

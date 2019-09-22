package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Enroll_Student_add_delete_Activity extends AppCompatActivity {

    CardView add_details,update_details,delete_details,show_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll__student_add_delete_);

        add_details=findViewById(R.id.student_add_details_id);
        update_details=findViewById(R.id.student_update_data_id);
        delete_details=findViewById(R.id.student_delete_data_id);
        show_details=findViewById(R.id.student_show_data_id);

        Bundle bundle=getIntent().getExtras();
        final String passvalue=bundle.getString("term");

        add_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Enroll_Student_add_delete_Activity.this,Student_enroll_add_data_Activity.class);
                startActivity(intent);
            }
        });
        show_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }
}

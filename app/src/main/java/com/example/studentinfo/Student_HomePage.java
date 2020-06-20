package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Student_HomePage extends AppCompatActivity {

    CardView studentdetails,coursedetails,percentage,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__home_page);
        coursedetails=findViewById(R.id.course_details_id);
        studentdetails=findViewById(R.id.students_details_id);
        percentage=findViewById(R.id.percentage_id);
        result=findViewById(R.id.result_id);

        coursedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_HomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","show_course");
                startActivity(intent);
            }
        });
        studentdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_HomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","student_details");
                startActivity(intent);
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_HomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","show_percentage");
                startActivity(intent);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Student_HomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","parent_show_result");
                startActivity(intent);
            }
        });
    }
}

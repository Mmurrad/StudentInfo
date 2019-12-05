package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class Teacher_Activity extends AppCompatActivity {

    private CardView enroll_course,enroll_students,take_attendance,show_percentage,student_details,show_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_);

        enroll_course=findViewById(R.id.enroll_course_id);
        enroll_students=findViewById(R.id.enroll_students_id);
        take_attendance=findViewById(R.id.take_attendance_id);
        show_percentage=findViewById(R.id.show_percentage_id);
        student_details=findViewById(R.id.students_details_id);
        show_result=findViewById(R.id.show_result_id);



        enroll_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Teacher_Activity.this,Semister_name_Activity.class);
                intent.putExtra("key","enroll_course");
                startActivity(intent);
            }
        });
        enroll_students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Teacher_Activity.this,Semister_name_Activity.class);
                intent.putExtra("key","enroll_students");
                startActivity(intent);
            }
        });
        student_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Teacher_Activity.this,Semister_name_Activity.class);
                intent.putExtra("key","student_details");
                startActivity(intent);
            }
        });
        take_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Teacher_Activity.this,Semister_name_Activity.class);
                intent.putExtra("key","take_attendance");
                startActivity(intent);
            }
        });
        show_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Teacher_Activity.this,Semister_name_Activity.class);
                intent.putExtra("key","show_percentage");
                startActivity(intent);
            }
        });
    }
}

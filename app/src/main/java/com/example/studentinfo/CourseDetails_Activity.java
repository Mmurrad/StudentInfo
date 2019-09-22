package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CourseDetails_Activity extends AppCompatActivity {

    private CardView add_details,update_details,delete_details,show_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details_);

        add_details=findViewById(R.id.add_details_id);
        update_details=findViewById(R.id.update_data_id);
        delete_details=findViewById(R.id.delete_data_id);
        show_details=findViewById(R.id.show_data_id);
        final Bundle bundle=getIntent().getExtras();
        final String passvalue=bundle.getString("term");
            add_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(CourseDetails_Activity.this,Add_Details_Of_Courses_Activity.class);
                    startActivity(intent);
                }
            });
            show_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(CourseDetails_Activity.this,ShowCourseDetails_Activity.class);
                    if(passvalue.equals("first")){
                        intent.putExtra("term","first");
                        startActivity(intent);
                    }
                    if(passvalue.equals("second")){
                        intent.putExtra("term","second");
                        startActivity(intent);
                    }
                    if(passvalue.equals("third")){
                        intent.putExtra("term","third");
                        startActivity(intent);
                    }
                    if(passvalue.equals("fourth")){
                        intent.putExtra("term","fourth");
                        startActivity(intent);
                    }
                    if(passvalue.equals("fifth")){
                        intent.putExtra("term","fifth");
                        startActivity(intent);
                    }
                    if(passvalue.equals("six")){
                        intent.putExtra("term","six");
                        startActivity(intent);
                    }
                    if(passvalue.equals("seven")){
                        intent.putExtra("term","seven");
                        startActivity(intent);
                    }
                    if(passvalue.equals("eight")){
                        intent.putExtra("term","eight");
                        startActivity(intent);
                    }
                }
            });
            delete_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(CourseDetails_Activity.this,ShowCourseDetails_Activity.class);
                    intent.putExtra("term","delete");
                    startActivity(intent);
                }
            });
    }
}

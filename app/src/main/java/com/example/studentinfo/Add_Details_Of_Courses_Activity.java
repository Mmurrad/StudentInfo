package com.example.studentinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Details_Of_Courses_Activity extends AppCompatActivity {

    private EditText teacher_name,course_title,reference_book,writtter_name;
    private Spinner year,semister;
    private Button save_data;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__details__of__courses_);

        teacher_name=findViewById(R.id.teacher_name_id);
        course_title=findViewById(R.id.course_title_id);
        reference_book=findViewById(R.id.reference_book_id);
        writtter_name=findViewById(R.id.writter_name_id);
        year=findViewById(R.id.year_spinner_id);
        semister=findViewById(R.id.semister_spinner_id);
        save_data=findViewById(R.id.save_data_id);

        databaseReference= FirebaseDatabase.getInstance().getReference("CourseDetails");

        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    savecoursedetails();
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void savecoursedetails() {

        String teacher=teacher_name.getText().toString();
        String title=course_title.getText().toString();
        String year_name=year.getSelectedItem().toString();
        String term=semister.getSelectedItem().toString();
        String book=reference_book.getText().toString();
        String writter=writtter_name.getText().toString();

        if(teacher.isEmpty())
        {
            teacher_name.setError("Enter name");
        }
        if (title.isEmpty())
        {
            course_title.setError("Enter Course Title");
        }
        if (book.isEmpty())
        {
            reference_book.setError("Enter book name");
        }
        if (writter.isEmpty())
        {
            writtter_name.setError("Enter writter");
        }

        else {
            try{
                AddCourseDetails addCourseDetails=new AddCourseDetails(teacher,title,book,writter,year_name,term);
                databaseReference.child(teacher).setValue(addCourseDetails);
                Toast.makeText(getApplicationContext(),"Data is added succesfully",Toast.LENGTH_SHORT).show();
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
            }

        }

    }
}

package com.example.studentinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class AddResult_Activity extends AppCompatActivity {

    EditText student_name,student_roll;
    EditText coursecode1,coursecode2,coursecode3,coursecode4,coursecode5,coursecode6,coursecode7,coursecode8,coursecode9,coursecode10;
    EditText grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10;
    EditText credit1,credit2,credit3,credit4,credit5,credit6,credit7,credit8,credit9,credit10;
    TextView tgpatextview;
    Button savebutton;
    Spinner result_year,result_semister;
    DatabaseReference databaseReference,databaseReference1;
    Double finaltgpa,tgpa,course1,course2,course3,course4,course5,course6,course7,course8,course9,course10;
    String output;
    Double g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;
    Integer c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0,c8=0,c9=0,c10=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result_);

        student_name=findViewById(R.id.result_name_id);
        student_roll=findViewById(R.id.result_roll_id);
        savebutton=findViewById(R.id.result_save_id);
        result_semister=findViewById(R.id.resul_semister_id);
        result_year=findViewById(R.id.resul_year_id);
        tgpatextview=findViewById(R.id.tgpaid);


        coursecode1=findViewById(R.id.course_1_code_id);
        coursecode2=findViewById(R.id.course_2_code_id);
        coursecode3=findViewById(R.id.course_3_code_id);
        coursecode4=findViewById(R.id.course_4_code_id);
        coursecode5=findViewById(R.id.course_5_code_id);
        coursecode6=findViewById(R.id.course_6_code_id);
        coursecode7=findViewById(R.id.course_7_code_id);
        coursecode8=findViewById(R.id.course_8_code_id);
        coursecode9=findViewById(R.id.course_9_code_id);
        coursecode10=findViewById(R.id.course_10_code_id);

        grade1=findViewById(R.id.grade_1_id);
        grade2=findViewById(R.id.grade_2_id);
        grade3=findViewById(R.id.grade_3_id);
        grade4=findViewById(R.id.grade_4_id);
        grade5=findViewById(R.id.grade_5_id);
        grade6=findViewById(R.id.grade_6_id);
        grade7=findViewById(R.id.grade_7_id);
        grade8=findViewById(R.id.grade_8_id);
        grade9=findViewById(R.id.grade_9_id);
        grade10=findViewById(R.id.grade_10_id);


        credit1=findViewById(R.id.credit_1_id);
        credit2=findViewById(R.id.credit_2_id);
        credit3=findViewById(R.id.credit_3_id);
        credit4=findViewById(R.id.credit_4_id);
        credit5=findViewById(R.id.credit_5_id);
        credit6=findViewById(R.id.credit_6_id);
        credit7=findViewById(R.id.credit_7_id);
        credit8=findViewById(R.id.credit_8_id);
        credit9=findViewById(R.id.credit_9_id);
        credit10=findViewById(R.id.credit_10_id);

        databaseReference=FirebaseDatabase.getInstance().getReference("Result");
        databaseReference1=FirebaseDatabase.getInstance().getReference("TGPA");
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    saveresult();
                    tgpacalculation();
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void saveresult() {
        String name=student_name.getText().toString().trim();
        String roll=student_roll.getText().toString().trim();
        String year=result_year.getSelectedItem().toString().trim();
        String semister=result_semister.getSelectedItem().toString().trim();

        String courseid1=coursecode1.getText().toString().trim();
        String courseid2=coursecode2.getText().toString().trim();
        String courseid3=coursecode3.getText().toString().trim();
        String courseid4=coursecode4.getText().toString().trim();
        String courseid5=coursecode5.getText().toString().trim();
        String courseid6=coursecode6.getText().toString().trim();
        String courseid7=coursecode7.getText().toString().trim();
        String courseid8=coursecode8.getText().toString().trim();
        String courseid9=coursecode9.getText().toString().trim();
        String courseid10=coursecode10.getText().toString().trim();

        String grade_no1=grade1.getText().toString().trim();
        String grade_no2=grade2.getText().toString().trim();
        String grade_no3=grade3.getText().toString().trim();
        String grade_no4=grade4.getText().toString().trim();
        String grade_no5=grade5.getText().toString().trim();
        String grade_no6=grade6.getText().toString().trim();
        String grade_no7=grade7.getText().toString().trim();
        String grade_no8=grade8.getText().toString().trim();
        String grade_no9=grade9.getText().toString().trim();
        String grade_no10=grade10.getText().toString().trim();

        String credit_no1=credit1.getText().toString().trim();
        String credit_no2=credit2.getText().toString().trim();
        String credit_no3=credit3.getText().toString().trim();
        String credit_no4=credit4.getText().toString().trim();
        String credit_no5=credit5.getText().toString().trim();
        String credit_no6=credit6.getText().toString().trim();
        String credit_no7=credit7.getText().toString().trim();
        String credit_no8=credit8.getText().toString().trim();
        String credit_no9=credit9.getText().toString().trim();
        String credit_no10=credit10.getText().toString().trim();



        if(name.isEmpty())
        {
            student_name.setError("Enter name");
        }
        if(roll.isEmpty())
        {
            student_roll.setError("Enter roll");
        }
        else{

            AddResult addResult=new AddResult(name,roll,year,semister,courseid1,credit_no1,grade_no1,courseid2,credit_no2,grade_no2,courseid3,credit_no3,grade_no3,courseid4,credit_no4,grade_no4,courseid5,credit_no5,grade_no5,courseid6,credit_no6,grade_no6,courseid7,credit_no7,grade_no7,courseid8,credit_no8,grade_no8,courseid9,credit_no9,grade_no9,courseid10,credit_no10,grade_no10);
            databaseReference.child(name+roll).setValue(addResult);
        }

    }

    private void tgpacalculation() {
        try{

            //Grade
            if(!grade1.getText().toString().isEmpty()&&!credit1.getText().toString().isEmpty())
            {
                g1=Double.parseDouble(grade1.getText().toString());
                c1= Integer.parseInt(credit1.getText().toString()) ;
                course1=c1*g1;
                tgpa=course1;

            }
            if(!grade2.getText().toString().isEmpty()&&!credit2.getText().toString().isEmpty())
            {
                g2=Double.parseDouble(grade2.getText().toString());
                c2= Integer.parseInt(credit2.getText().toString());
                course2=c2*g2;
                tgpa=tgpa+course2;

            }
            if(!grade3.getText().toString().isEmpty()&&!credit3.getText().toString().isEmpty())
            {
                g3=Double.parseDouble(grade3.getText().toString());
                c3= Integer.parseInt(credit3.getText().toString());
                course3=c3*g3;
                tgpa=tgpa+course3;
            }
            if(!grade4.getText().toString().isEmpty()&&!credit4.getText().toString().isEmpty())
            {
                g4=Double.parseDouble(grade4.getText().toString());
                c4= Integer.parseInt(credit4.getText().toString());
                course4=c4*g4;
                tgpa=tgpa+course4;
            }
            if(!grade5.getText().toString().isEmpty()&&!credit5.getText().toString().isEmpty())
            {
                g5=Double.parseDouble(grade5.getText().toString());
                c5= Integer.parseInt(credit5.getText().toString());
                course5=c5*g5;
                tgpa=tgpa+course5;
            }
            if(!grade6.getText().toString().isEmpty()&&!credit6.getText().toString().isEmpty())
            {
                g6=Double.parseDouble(grade6.getText().toString());
                c6= Integer.parseInt(credit6.getText().toString());
                course6=c6*g6;
                tgpa=tgpa+course6;
            }
            if(!grade7.getText().toString().isEmpty()&&!credit7.getText().toString().isEmpty())
            {
                g7=Double.parseDouble(grade7.getText().toString());
                c7= Integer.parseInt(credit7.getText().toString());
                course7=c7*g7;
                tgpa=tgpa+course7;
            }
            if(!grade8.getText().toString().isEmpty()&&!credit8.getText().toString().isEmpty())
            {
                g8=Double.parseDouble(grade8.getText().toString());
                c8= Integer.parseInt(credit8.getText().toString());
                course8=c8*g8;
                tgpa=tgpa+course8;
            }
            if(!grade9.getText().toString().isEmpty()&&!credit9.getText().toString().isEmpty())
            {
                g9=Double.parseDouble(grade9.getText().toString());
                c9= Integer.parseInt(credit9.getText().toString());
                course9=c9*g9;
                tgpa=tgpa+course9;
            }
            if(!grade10.getText().toString().isEmpty()&&!credit10.getText().toString().isEmpty())
            {
                g10=Double.parseDouble(grade10.getText().toString());
                c10= Integer.parseInt(credit10.getText().toString());
                course10=c10*g10;
                tgpa=tgpa+course10;
            }
            Integer credit=(c1+c2+c3+c4+c5+c6+c7+c8+c9+c10);

            finaltgpa=tgpa/credit;
            Toast.makeText(getApplicationContext(),"TGPA "+finaltgpa,Toast.LENGTH_LONG).show();
            tgpatextview.setText(finaltgpa.toString());
            String name=student_name.getText().toString().trim();
            String roll=student_roll.getText().toString().trim();
            String year=result_year.getSelectedItem().toString().trim();
            String semister=result_semister.getSelectedItem().toString().trim();
            AddResult addResult1=new AddResult(finaltgpa.toString(),name,roll,year,semister);
            databaseReference1.child(name).setValue(addResult1);

        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
        }

    }
}

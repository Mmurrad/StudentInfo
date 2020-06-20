package com.example.studentinfo;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowPercentageStudentList extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference,databaseReference1;
    Student_Model student_model;
    PresentClass presentClass;
    private List<Student_Model> list1_1,list1_2,list2_1,list2_2,list3_1,list3_2,list4_1,list4_2;
    private List<PresentClass> presentClasses4_2;
    String passvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_percentage_student_list);
        listView=findViewById(R.id.showpercentagelistview);
        databaseReference= FirebaseDatabase.getInstance().getReference("Student_Details");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Present");
        presentClass=new PresentClass(PresentClass.class);

        list1_1=new ArrayList<>();
        list1_2=new ArrayList<>();
        list2_1=new ArrayList<>();
        list2_2=new ArrayList<>();
        list3_1=new ArrayList<>();
        list3_2=new ArrayList<>();
        list4_1=new ArrayList<>();
        list4_2=new ArrayList<>();
        presentClasses4_2=new ArrayList<>();


        final Bundle bundle=getIntent().getExtras();
        passvalue=bundle.getString("term");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list1_1.clear();
                list1_2.clear();
                list2_1.clear();
                list2_2.clear();
                list3_1.clear();
                list3_2.clear();
                list4_1.clear();
                list4_2.clear();

                if(passvalue.equals("first"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("1st year")&&student_model.getSemister().equals("1st term")){
                                list1_1.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list1_1);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("second"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("1st year")&&student_model.getSemister().equals("2nd term")){
                                list1_2.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list1_2);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("third"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("2nd year")&&student_model.getSemister().equals("1st term")){
                                list2_1.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list2_1);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("fourth"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("2nd year")&&student_model.getSemister().equals("2nd term")){
                                list2_2.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list2_2);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("fifth"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("3rd year")&&student_model.getSemister().equals("1st term")){
                                list3_1.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list3_1);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("six"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("3rd year")&&student_model.getSemister().equals("2nd term")){
                                list3_2.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list3_2);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("seven"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("4th year")&&student_model.getSemister().equals("1st term")){
                                list4_1.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list4_1);
                    listView.setAdapter(attendanceAdapter);
                }


                else if(passvalue.equals("eight"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        try{
                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_model.getYear().equals("4th year")&&student_model.getSemister().equals("2nd term")){
                                list4_2.add(student_model);
                            }
                        }catch (Exception e)
                        {

                        }
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list4_2);
                    listView.setAdapter(attendanceAdapter);


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(ShowPercentageStudentList.this);
                            alertdialogbuilder.setTitle("Class Attendance");
                            LayoutInflater layoutInflater=getLayoutInflater();
                            final View view1=layoutInflater.inflate(R.layout.class_attendance_details,null);
                            final EditText totalclass=view1.findViewById(R.id.totalclassid);
                            final TextView present=view1.findViewById(R.id.presentclassid);
                            final TextView absent=view1.findViewById(R.id.absentclassid);
                            final EditText valid=view1.findViewById(R.id.valid_or_invalid_id);

                            try{
                                Toast.makeText(getApplicationContext()," "+presentClasses4_2.get(i).getPresent(),Toast.LENGTH_LONG).show();
                            }catch (Exception e)
                            {
                                Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_LONG).show();
                            }
                            alertdialogbuilder.setView(view1);
                            AlertDialog alertDialog=alertdialogbuilder.create();
                            alertDialog.show();

                        }
                    });

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


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
    private List<Student_Model> list;
    String passvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_percentage_student_list);
        listView=findViewById(R.id.showpercentagelistview);
        databaseReference= FirebaseDatabase.getInstance().getReference("Student_Details");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Present");
        list=new ArrayList<>();
        final Bundle bundle=getIntent().getExtras();
        passvalue=bundle.getString("term");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    try{
                        student_model=dataSnapshot1.getValue(Student_Model.class);
                        if(student_model.getYear().equals("1st year")&&student_model.getSemister().equals("1st term")){
                            list.add(student_model);
                        }
                    }catch (Exception e)
                    {

                    }
                }
                AttendanceAdapter attendanceAdapter=new AttendanceAdapter(ShowPercentageStudentList.this,list);
                listView.setAdapter(attendanceAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(ShowPercentageStudentList.this);
                        alertdialogbuilder.setTitle("Class Attendance");
                        LayoutInflater layoutInflater=getLayoutInflater();
                        final View view1=layoutInflater.inflate(R.layout.class_attendance_details,null);
                        final EditText totalclass=view1.findViewById(R.id.totalclassid);
                        final EditText present=view1.findViewById(R.id.presentclassid);
                        final TextView absent=view1.findViewById(R.id.absentclassid);
                        final TextView valid=view1.findViewById(R.id.valid_or_invalid_id);



                        alertdialogbuilder.setView(view1);
                        AlertDialog alertDialog=alertdialogbuilder.create();
                        alertDialog.show();

                        databaseReference1.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                                {
                                    try{
                                         presentClass=dataSnapshot1.getValue(PresentClass.class);
                                         

                                    }catch (Exception e)
                                    {

                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}


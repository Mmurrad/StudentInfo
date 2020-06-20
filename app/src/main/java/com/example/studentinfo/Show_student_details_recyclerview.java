package com.example.studentinfo;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Show_student_details_recyclerview extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student_Model> student_modelList1_1;
    private List<Student_Model> student_modelList1_2;
    private List<Student_Model> student_modelList2_1;
    private List<Student_Model> student_modelList2_2;
    private List<Student_Model> student_modelList3_1;
    private List<Student_Model> student_modelList3_2;
    private List<Student_Model> student_modelList4_1;
    private List<Student_Model> student_modelList4_2;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_student_details_recyclerview);
        recyclerView=findViewById(R.id.recyclerviewid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        final Bundle bundle=getIntent().getExtras();
        final String passvalue=bundle.getString("term");

        databaseReference= FirebaseDatabase.getInstance().getReference("Student_Details");
        student_modelList1_1=new ArrayList<>();
        student_modelList1_2=new ArrayList<>();
        student_modelList2_1=new ArrayList<>();
        student_modelList2_2=new ArrayList<>();
        student_modelList3_1=new ArrayList<>();
        student_modelList3_2=new ArrayList<>();
        student_modelList4_1=new ArrayList<>();
        student_modelList4_2=new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                student_modelList1_1.clear();
                student_modelList1_2.clear();
                student_modelList2_1.clear();
                student_modelList2_2.clear();
                student_modelList3_1.clear();
                student_modelList3_2.clear();
                student_modelList4_1.clear();
                student_modelList4_2.clear();

                if(passvalue.equals("first")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("1st year")&&student_model.getSemister().equals("1st term")){
                                student_modelList1_1.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList1_1);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("second")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("1st year")&&student_model.getSemister().equals("2nd term")){
                                student_modelList1_2.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList1_2);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("third")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("2nd year")&&student_model.getSemister().equals("1st term")){
                                student_modelList2_1.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList2_1);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("fourth")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("2nd year")&&student_model.getSemister().equals("2nd term")){
                                student_modelList2_2.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList2_2);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("fifth")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("3rd year")&&student_model.getSemister().equals("1st term")){
                                student_modelList3_1.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList3_1);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("six")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("3rd year")&&student_model.getSemister().equals("2nd term")){
                                student_modelList3_2.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList1_2);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("seven")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("4th year")&&student_model.getSemister().equals("1st term")){
                                student_modelList4_1.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList4_1);
                    recyclerView.setAdapter(studentAdapter);
                }
                else if(passvalue.equals("eight")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        try{
                            if(student_model.getYear().equals("4th year")&&student_model.getSemister().equals("2nd term")){
                                student_modelList4_2.add(student_model) ;
                            }
                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(),"Error "+e,Toast.LENGTH_LONG).show();
                        }

                    }
                    studentAdapter=new StudentAdapter(Show_student_details_recyclerview.this,student_modelList4_2);
                    recyclerView.setAdapter(studentAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

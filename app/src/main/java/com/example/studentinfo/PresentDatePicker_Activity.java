package com.example.studentinfo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PresentDatePicker_Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    DatabaseReference databaseReference,databaseReference1,databaseReference2;
    int presentcount,absentcount=0;
    private ListView listView;
    private Button savebutton;
    Student_Model student_model;
    String itemname,count;
    private CheckBox presentcheckbox,absentcheckbox;
    private List<Student_Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_date_picker_);
        listView=findViewById(R.id.datepickerlistview);
        presentcheckbox=findViewById(R.id.present_checkbox_id);
        absentcheckbox=findViewById(R.id.absent_checkbox_id);
        savebutton=findViewById(R.id.presentsavebutton_id);
        list= new ArrayList<>();

        DialogFragment datapicker=new DatePickerFragment();
        datapicker.show(getSupportFragmentManager(),"Date picker");
        databaseReference= FirebaseDatabase.getInstance().getReference("DatePicker");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Student_Details");
        databaseReference2= FirebaseDatabase.getInstance().getReference("Present_Absent");


    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,i);
        calendar.set(Calendar.MONTH,i1);
        calendar.set(Calendar.DAY_OF_MONTH,i2);
        String currentdatastring = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        DatePickerClass datePickerClass=new DatePickerClass(currentdatastring);
        databaseReference.child(currentdatastring).setValue(datePickerClass);
        if(!currentdatastring.isEmpty()){

            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    list.clear();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        student_model=dataSnapshot1.getValue(Student_Model.class);
                        list.add(student_model);
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list);
                    listView.setAdapter(attendanceAdapter);
                    presentcount=0;
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, final long l) {
                            AlertDialog.Builder alerdialogbuilder=new AlertDialog.Builder(PresentDatePicker_Activity.this);
                            alerdialogbuilder.setTitle("Select Option");
                            LayoutInflater layoutInflater=getLayoutInflater();
                            final View view1=layoutInflater.inflate(R.layout.sample_take_attendance,null);
                            final TextView present=view1.findViewById(R.id.present_checkbox_id);
                            TextView absent=view1.findViewById(R.id.absent_checkbox_id);

                            alerdialogbuilder.setView(view1);
                            final AlertDialog alertDialog=alerdialogbuilder.create();
                            alertDialog.show();
                            if(!list.get(i).getName().isEmpty()){
                                Toast.makeText(getApplicationContext()," "+list.get(i).getName(),Toast.LENGTH_SHORT).show();
                                itemname=list.get(i).getName();
                               present.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        PresentClass presentClass=new PresentClass(presentcount);
                                        if(presentcount==0){
                                            databaseReference2.child(itemname).setValue(presentClass);
                                            presentcount++;
                                        }
                                        else {
                                            PresentClass presentClass1=new PresentClass(presentClass.getPresent()+1);
                                            databaseReference2.child(itemname).setValue(presentClass1);
                                        }
                                        alertDialog.dismiss();
                                    }
                                });
                            }
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }

    private void alertdialog(final String student_name) {
        AlertDialog.Builder alerdialogbuilder=new AlertDialog.Builder(PresentDatePicker_Activity.this);
        alerdialogbuilder.setTitle("Select Option");
        LayoutInflater layoutInflater=getLayoutInflater();
        final View view=layoutInflater.inflate(R.layout.sample_take_attendance,null);
        final TextView present=view.findViewById(R.id.present_checkbox_id);
        TextView absent=view.findViewById(R.id.absent_checkbox_id);

        alerdialogbuilder.setView(view);
        final AlertDialog alertDialog=alerdialogbuilder.create();
        alertDialog.show();

        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        presentcount=0;
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {

                            student_model=dataSnapshot1.getValue(Student_Model.class);
                            if(student_name==student_model.getName()){
                                presentcount++;
                                PresentClass presentClass=new PresentClass(presentcount);
                                databaseReference2.child(student_model.getName()).setValue(presentClass);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                alertDialog.dismiss();
            }
        });

    }
}

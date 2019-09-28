package com.example.studentinfo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;

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

    DatabaseReference databaseReference,databaseReference1;
    private ListView listView;
    private List<Student_Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_date_picker_);
        listView=findViewById(R.id.datepickerlistview);
        list= new ArrayList<>();
        DialogFragment datapicker=new DatePickerFragment();
        datapicker.show(getSupportFragmentManager(),"Date picker");
        databaseReference= FirebaseDatabase.getInstance().getReference("DatePicker");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Student_Details");
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
                        Student_Model student_model=dataSnapshot1.getValue(Student_Model.class);
                        list.add(student_model);
                    }
                    AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list);
                    listView.setAdapter(attendanceAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
}

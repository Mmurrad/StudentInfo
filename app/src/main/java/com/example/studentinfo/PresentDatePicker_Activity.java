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

    DatabaseReference databaseReference,databaseReference1,databaseReference2,databaseReference3;
    int presentcount,absentcount=0,count=0,count1=0;
    private ListView listView;
    private Button savebutton;
    Student_Model student_model;
    String itemname;
    private CheckBox presentcheckbox,absentcheckbox;
    private List<Student_Model> list1_1,list1_2,list2_1,list2_2,list3_1,list3_2,list4_1,list4_2;
    String passvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_date_picker_);
        listView=findViewById(R.id.datepickerlistview);
        presentcheckbox=findViewById(R.id.present_checkbox_id);
        absentcheckbox=findViewById(R.id.absent_checkbox_id);
        final Bundle bundle=getIntent().getExtras();
        passvalue=bundle.getString("term");
        list1_1=new ArrayList<>();
        list1_2=new ArrayList<>();
        list2_1=new ArrayList<>();
        list2_2=new ArrayList<>();
        list3_1=new ArrayList<>();
        list3_2=new ArrayList<>();
        list4_1=new ArrayList<>();
        list4_2=new ArrayList<>();

        DialogFragment datapicker=new DatePickerFragment();
        datapicker.show(getSupportFragmentManager(),"Date picker");
        databaseReference= FirebaseDatabase.getInstance().getReference("DatePicker");
        databaseReference1= FirebaseDatabase.getInstance().getReference("Student_Details");
        databaseReference2= FirebaseDatabase.getInstance().getReference("Present");
        databaseReference3= FirebaseDatabase.getInstance().getReference("Absent");
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
                    list1_1.clear();
                    list1_2.clear();
                    list2_1.clear();
                    list2_2.clear();
                    list3_1.clear();
                    list3_2.clear();
                    list4_1.clear();
                    list4_2.clear();

                    if(passvalue.equals("first")){
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list1_1);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list1_2);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list2_1);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list2_2);
                        listView.setAdapter(attendanceAdapter);
                    }

                    else if(passvalue.equals("five"))
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list3_1);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list3_2);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list4_1);
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
                        AttendanceAdapter attendanceAdapter=new AttendanceAdapter(PresentDatePicker_Activity.this,list4_2);
                        listView.setAdapter(attendanceAdapter);
                    }


                    presentcount=0;
                    absentcount=0;
                   // final PresentClass presentClass=new PresentClass(presentcount);

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
                            if(passvalue.equals("first")){
                                if(!list1_1.get(i).getName().isEmpty()){
                                    Toast.makeText(getApplicationContext()," "+list1_1.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list1_1.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("second"))
                            {
                                if(!list1_2.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list1_2.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list1_2.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {

                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("third"))
                            {
                                if(!list2_1.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list2_1.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list2_1.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("fourth"))
                            {
                                if(!list2_2.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list2_2.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list2_2.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("five"))
                            {
                                if(!list3_1.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list3_1.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list3_1.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }



                            else if(passvalue.equals("six"))
                            {
                                if(!list3_2.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list3_2.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list3_2.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {

                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("seven"))
                            {
                                if(!list4_1.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list4_1.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list4_1.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {

                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
                            }


                            else if(passvalue.equals("eight"))
                            {
                                if(!list4_2.get(i).getName().isEmpty())
                                {
                                    Toast.makeText(getApplicationContext()," "+list4_2.get(i).getName(),Toast.LENGTH_SHORT).show();
                                    itemname=list4_2.get(i).getName();

                                    present.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(presentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname)){
                                                    PresentClass presentClass1=new PresentClass(count);
                                                    databaseReference2.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference2.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }

                                            alertDialog.dismiss();
                                            count=presentcount++;
                                        }
                                    });
                                    absent.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if(absentcount==0)
                                            {
                                                if(student_model.getName().equals(itemname))
                                                {
                                                    PresentClass presentClass1=new PresentClass(count1);
                                                    databaseReference3.child(itemname).setValue(presentClass1);
                                                }
                                            }
                                            else {
                                                PresentClass presentClass1=new PresentClass(count);
                                                databaseReference3.child(itemname).setValue(presentClass1.getPresent()+1);
                                            }
                                            alertDialog.dismiss();
                                            count1=absentcount++;
                                        }
                                    });
                                }
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

}

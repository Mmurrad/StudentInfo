package com.example.studentinfo;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowCourseDetails_Activity extends AppCompatActivity {

    private ListView listView;
    private List<AddCourseDetails> firstlist;
    private List<AddCourseDetails> secondlist;
    private List<AddCourseDetails> thirdlist;
    private List<AddCourseDetails> fourthlist;
    private List<AddCourseDetails> fifthhlist;
    private List<AddCourseDetails> sixlist;
    private List<AddCourseDetails> sevenlist;
    private List<AddCourseDetails> eightlist;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_course_details_);
        listView=findViewById(R.id.courselistview_id);

        databaseReference= FirebaseDatabase.getInstance().getReference("CourseDetails");
        firstlist=new ArrayList<>();
        secondlist=new ArrayList<>();
        thirdlist=new ArrayList<>();
        fourthlist=new ArrayList<>();
        fifthhlist=new ArrayList<>();
        sixlist=new ArrayList<>();
        sevenlist=new ArrayList<>();
        eightlist=new ArrayList<>();
    }

    @Override
    protected void onStart() {

        super.onStart();
        final Bundle bundle=getIntent().getExtras();
        final String passvalue=bundle.getString("term");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                firstlist.clear();
                secondlist.clear();
                thirdlist.clear();
                fourthlist.clear();
                fifthhlist.clear();
                sixlist.clear();
                sevenlist.clear();
                eightlist.clear();

                if(passvalue.equals("first")|| passvalue.equals("delete")){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("1st year")&&addCourseDetails.getSemister().equals("1st term"))
                        {
                            firstlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,firstlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("second")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("1st year")&&addCourseDetails.getSemister().equals("2nd term"))
                        {
                            secondlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,secondlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("third")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("2nd year")&&addCourseDetails.getSemister().equals("1st term"))
                        {
                            thirdlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,thirdlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("fourth")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("2nd year")&&addCourseDetails.getSemister().equals("2nd term"))
                        {
                            fourthlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,fourthlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("fifth")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("3rd year")&&addCourseDetails.getSemister().equals("1st term"))
                        {
                            fifthhlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,fifthhlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("six")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("3rd year")&&addCourseDetails.getSemister().equals("2nd term"))
                        {
                            sixlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,sixlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("seven")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("4th year")&&addCourseDetails.getSemister().equals("1st term"))
                        {
                            sevenlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,sevenlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }


                else if (passvalue.equals("eight")|| passvalue.equals("delete"))
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        AddCourseDetails addCourseDetails=dataSnapshot1.getValue(AddCourseDetails.class);
                        if(addCourseDetails.getYear().equals("4th year")&&addCourseDetails.getSemister().equals("2nd term"))
                        {
                            eightlist.add(addCourseDetails);
                        }
                    }
                    CustomAdapter customAdapter=new CustomAdapter(ShowCourseDetails_Activity.this,eightlist);
                    listView.setAdapter(customAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            deleteData();
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void deleteData() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View view=inflater.inflate(R.layout.delete_sample,null);
        builder.setView(view);

        final EditText deletename=(EditText)view.findViewById(R.id.edittext_coursename_id);
        final Button deletebutton=(Button)view.findViewById(R.id.button_delete_id);

        builder.setTitle("Delete name ");
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=deletename.getText().toString().trim();
                deletepdf(name);
                alertDialog.dismiss();
            }
        });
    }

    private void deletepdf(String name) {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("CourseDetails").child(name);
        databaseReference.removeValue();
    }

}

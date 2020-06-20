package com.example.studentinfo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowResultActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ResultShowAdapter showAdapter;
    private List<AddResult> addResults1_1;
    private List<AddResult> addResults1_2;
    private List<AddResult> addResults2_1;
    private List<AddResult> addResults2_2;
    private List<AddResult> addResults3_1;
    private List<AddResult> addResults3_2;
    private List<AddResult> addResults4_1;
    private List<AddResult> addResults4_2;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        recyclerView=findViewById(R.id.result_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
   protected void onStart() {
        super.onStart();
        try{

            Bundle bundle=getIntent().getExtras();
            final String passvalue=bundle.getString("result");
            databaseReference= FirebaseDatabase.getInstance().getReference("TGPA");
            addResults1_1=new ArrayList<>();
            addResults1_2=new ArrayList<>();
            addResults2_1=new ArrayList<>();
            addResults2_2=new ArrayList<>();
            addResults3_1=new ArrayList<>();
            addResults3_2=new ArrayList<>();
            addResults4_1=new ArrayList<>();
            addResults4_2=new ArrayList<>();


            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    addResults1_1.clear();
                    addResults1_2.clear();
                    addResults2_1.clear();
                    addResults2_2.clear();
                    addResults3_1.clear();
                    addResults3_2.clear();
                    addResults4_1.clear();
                    addResults3_2.clear();
                    if(passvalue.equals("first"))
                    {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {
                            try{
                                AddResult addResult=dataSnapshot1.getValue(AddResult.class);
                                if(addResult.getYear().equals("1st year")&&addResult.getSemister().equals("1st term"))
                                {
                                    addResults1_1.add(addResult);
                                }
                            }catch (Exception e)
                            {

                            }
                        }
                        showAdapter=new ResultShowAdapter(ShowResultActivity.this,addResults1_1);
                        recyclerView.setAdapter(showAdapter);
                    }


                    else if(passvalue.equals("second"))
                    {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {
                            try{
                                AddResult addResult=dataSnapshot1.getValue(AddResult.class);
                                if(addResult.getYear().equals("1st year")&&addResult.getSemister().equals("2nd term"))
                                {
                                    addResults1_2.add(addResult);
                                }
                            }catch (Exception e)
                            {

                            }
                        }
                        showAdapter=new ResultShowAdapter(ShowResultActivity.this,addResults1_2);
                        recyclerView.setAdapter(showAdapter);
                    }


                    else if(passvalue.equals("third"))
                    {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                        {
                            try{
                                AddResult addResult=dataSnapshot1.getValue(AddResult.class);
                                if(addResult.getYear().equals("2nd year")&&addResult.getSemister().equals("1st term"))
                                {
                                    addResults2_1.add(addResult);
                                }
                            }catch (Exception e)
                            {

                            }
                        }
                        showAdapter=new ResultShowAdapter(ShowResultActivity.this,addResults2_1);
                        recyclerView.setAdapter(showAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
        }

    }
}

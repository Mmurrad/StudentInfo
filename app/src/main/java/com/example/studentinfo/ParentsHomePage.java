package com.example.studentinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class ParentsHomePage extends AppCompatActivity {

    CardView percentage,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_home_page);
        percentage=findViewById(R.id.percentage_id);
        result=findViewById(R.id.result_id);

    }
}

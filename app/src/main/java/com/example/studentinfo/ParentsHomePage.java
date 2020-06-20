package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class ParentsHomePage extends AppCompatActivity {

    CardView percentage,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_home_page);
        percentage=findViewById(R.id.percentage_id);
        result=findViewById(R.id.result_id);

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ParentsHomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","show_percentage");
                startActivity(intent);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ParentsHomePage.this,Semister_name_Activity.class);
                intent.putExtra("key","parent_show_result");
                startActivity(intent);
            }
        });
    }
}

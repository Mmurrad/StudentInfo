package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Notice_board_Activity extends AppCompatActivity {

    private CardView addbutton,deletebutton,updatebutton,showbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board_);

        addbutton=findViewById(R.id.additem);
        deletebutton=findViewById(R.id.deleteitem);
        updatebutton=findViewById(R.id.updateitem);
        showbutton=findViewById(R.id.showitem);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Notice_board_Activity.this,Uploadfile_Activity.class);
                startActivity(intent);
            }
        });
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Notice_board_Activity.this,ListOfPdf_Activity.class);
                intent.putExtra("key","showdata");
                startActivity(intent);
            }
        });
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Notice_board_Activity.this,UpdateDelete_Activity .class);
                intent.putExtra("key","updatedata");
                startActivity(intent);
            }
        });
    }
}

package com.example.studentinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button notice_board,teacher,students,parents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notice_board=findViewById(R.id.notice_board_id);
        teacher=findViewById(R.id.teacher_id);
        students=findViewById(R.id.student_id);
        parents=findViewById(R.id.parents_id);

        notice_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Notice_board_Activity.class);
                startActivity(intent);
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(MainActivity.this,Teacher_Activity.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext()," "+e,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

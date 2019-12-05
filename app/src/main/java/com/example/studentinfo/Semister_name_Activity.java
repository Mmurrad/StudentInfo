package com.example.studentinfo;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Semister_name_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView first,second,third,fourth,fifth,six,seven,eight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semister_name_);

        first=findViewById(R.id.first_semister_id);
        second=findViewById(R.id.second_semister_id);
        third=findViewById(R.id.third_semister_id);
        fourth=findViewById(R.id.fourth_semister_id);
        fifth=findViewById(R.id.fifth_semister_id);
        six=findViewById(R.id.six_semister_id);
        seven=findViewById(R.id.seven_semister_id);
        eight=findViewById(R.id.eight_semister_id);


        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        fifth.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final Bundle bundle=getIntent().getExtras();
        final String passkey=bundle.getString("key");

        if(passkey.equals("enroll_course")){
            if(view.getId()==R.id.first_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","first");
                startActivity(intent);
            }
            else if(view.getId()==R.id.second_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","second");
                startActivity(intent);
            }
            else if(view.getId()==R.id.third_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","third");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fourth_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","fourth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fifth_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","fifth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.six_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","six");
                startActivity(intent);
            }
            else if(view.getId()==R.id.seven_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","seven");
                startActivity(intent);
            }
            else if(view.getId()==R.id.eight_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,CourseDetails_Activity.class);
                intent.putExtra("term","eight");
                startActivity(intent);
            }
        }

        if(passkey.equals("enroll_students"))
        {

            if(view.getId()==R.id.first_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","first");
                startActivity(intent);
            }
            else if(view.getId()==R.id.second_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","second");
                startActivity(intent);
            }
            else if(view.getId()==R.id.third_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","third");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fourth_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","fourth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fifth_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","fifth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.six_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","six");
                startActivity(intent);
            }
            else if(view.getId()==R.id.seven_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","seven");
                startActivity(intent);
            }
            else if(view.getId()==R.id.eight_semister_id){
                Intent intent=new Intent(Semister_name_Activity.this,Enroll_Student_add_delete_Activity.class);
                intent.putExtra("term","eight");
                startActivity(intent);
            }
        }
        if (passkey.equals("student_details"))
        {
            Intent intent=new Intent(Semister_name_Activity.this,Show_student_details_recyclerview.class);
            if(view.getId()==R.id.first_semister_id)
            {
                intent.putExtra("term","first");
                startActivity(intent);
            }
            else if(view.getId()==R.id.second_semister_id)
            {
                intent.putExtra("term","second");
                startActivity(intent);
            }
            else if(view.getId()==R.id.third_semister_id)
            {
                intent.putExtra("term","third");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fourth_semister_id)
            {
                intent.putExtra("term","fourth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fifth_semister_id)
            {
                intent.putExtra("term","fifth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.six_semister_id)
            {
                intent.putExtra("term","six");
                startActivity(intent);
            }
            else if(view.getId()==R.id.seven_semister_id)
            {
                intent.putExtra("term","seven");
                startActivity(intent);
            }
            else if(view.getId()==R.id.eight_semister_id)
            {
                intent.putExtra("term","eight");
                startActivity(intent);
            }
        }
        if(passkey.equals("take_attendance"))
        {
            Intent intent=new Intent(Semister_name_Activity.this,PresentDatePicker_Activity.class);
            if(view.getId()==R.id.first_semister_id)
            {
                intent.putExtra("term","first");
                startActivity(intent);
            }
            else if(view.getId()==R.id.second_semister_id)
            {
                intent.putExtra("term","second");
                startActivity(intent);
            }
            else if(view.getId()==R.id.third_semister_id)
            {
                intent.putExtra("term","third");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fourth_semister_id)
            {
                intent.putExtra("term","fourth");
                startActivity(intent);
            }
            else if(view.getId()==R.id.fifth_semister_id)
            {
                intent.putExtra("term","five");
                startActivity(intent);
            }
            else if(view.getId()==R.id.six_semister_id)
            {
                intent.putExtra("term","six");
                startActivity(intent);
            }
            else if(view.getId()==R.id.seven_semister_id)
            {
                intent.putExtra("term","seven");
                startActivity(intent);
            }
            else if(view.getId()==R.id.eight_semister_id)
            {
                intent.putExtra("term","eight");
                startActivity(intent);
            }

        }
        if(passkey.equals("show_percentage"))
        {
            Intent intent=new Intent(Semister_name_Activity.this,ShowPercentageStudentList.class);
            intent.putExtra("term","first");
            startActivity(intent);
        }
    }

}

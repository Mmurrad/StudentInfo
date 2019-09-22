package com.example.studentinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private Context context;
    private List<Student_Model> student_models;

    public StudentAdapter(Context context, List<Student_Model> student_models) {
        this.context = context;
        this.student_models = student_models;
    }

    @NonNull
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recyclerview_sample_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyViewHolder myViewHolder, int i) {
        Student_Model studentModel=student_models.get(i);
        myViewHolder.name.setText(studentModel.getName());
        myViewHolder.roll.setText(studentModel.getRoll());
        myViewHolder.school.setText(studentModel.getSchool_name());
        myViewHolder.college.setText(studentModel.getCollege_name());
        myViewHolder.home.setText(studentModel.getHome_town());
        myViewHolder.birth.setText(studentModel.getBirthday());
        myViewHolder.mobile.setText(studentModel.getPhone());
        myViewHolder.mail.setText(studentModel.getEmail());
        myViewHolder.year.setText(studentModel.getYear());
        myViewHolder.semister.setText(studentModel.getSemister());
        Picasso.with(context).
                load(student_models.get(i).getImage()).
                placeholder(R.mipmap.ic_launcher_round).
                fit().into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return student_models.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,school,college,home,birth,mobile,mail,roll,year,semister;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.recy_name_id);
            roll=itemView.findViewById(R.id.recy_roll_id);
            school=itemView.findViewById(R.id.recy_schoolname_id);
            college=itemView.findViewById(R.id.recy_collegename_id);
            home=itemView.findViewById(R.id.recy_hometown_id);
            birth=itemView.findViewById(R.id.recy_birth_id);
            mobile=itemView.findViewById(R.id.recy_phone_id);
            mail=itemView.findViewById(R.id.recy_email_id);
            imageView=itemView.findViewById(R.id.recyclerimage_id);
            year=itemView.findViewById(R.id.recy_year_id);
            semister=itemView.findViewById(R.id.recy_semister_id);
        }
    }
}

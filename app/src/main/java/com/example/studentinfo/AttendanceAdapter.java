package com.example.studentinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AttendanceAdapter extends ArrayAdapter<Student_Model> {



    private Activity context;
    private List<Student_Model> student_models;
    public AttendanceAdapter(Activity context, List<Student_Model> student_models)  {
        super(context, R.layout.take_attendance_layout,student_models);
        this.context=context;
        this.student_models=student_models;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.take_attendance_layout,null,true);

        TextView name=view.findViewById(R.id.atten_name_id);
        TextView roll=view.findViewById(R.id.atten_roll_id);

        Student_Model details=student_models.get(position);

        name.setText(details.getName());
        roll.setText(details.getRoll());
        return view;
    }
}

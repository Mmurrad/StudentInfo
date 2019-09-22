package com.example.studentinfo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<AddCourseDetails> {
    private Activity context;
    private List<AddCourseDetails> courseDetailsList;

    public CustomAdapter( Activity context, List<AddCourseDetails> courseDetailsList) {
        super(context, R.layout.sample_of_course_details,courseDetailsList);
        this.context=context;
        this.courseDetailsList=courseDetailsList;
    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.sample_of_course_details,null,true);
        TextView teacher=(TextView)view.findViewById(R.id.teacher_name);
        TextView course=(TextView)view.findViewById(R.id.course_name);
        TextView book=(TextView)view.findViewById(R.id.book_name);
        TextView writtter=(TextView)view.findViewById(R.id.writter_name);
        TextView year=(TextView)view.findViewById(R.id.year_id);
        TextView term=(TextView)view.findViewById(R.id.semister_id);
        TextView teacher_name=(TextView)view.findViewById(R.id.hint_teacher_name);
        TextView course_name=(TextView)view.findViewById(R.id.hint_course_name);
        TextView writter_name=(TextView)view.findViewById(R.id.hint_writter_name);
        TextView book_name=(TextView)view.findViewById(R.id.hint_book_name);

        AddCourseDetails details=courseDetailsList.get(position);
        teacher.setText(details.getTeachername());
        course.setText(details.getCoursename());
        book.setText(details.getReferencebook());
        writtter.setText(details.getWrittername());
        year.setText(details.getYear());
        term.setText(details.getSemister());
        //teacher_name.setText(R.id.hint_teacher_name);

        return view;
    }

}

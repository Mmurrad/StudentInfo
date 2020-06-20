package com.example.studentinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ResultShowAdapter extends RecyclerView.Adapter<ResultShowAdapter.MyViewHolder> {
    private Context context;
    private List<AddResult> addResults;
    public ResultShowAdapter(Context context,List<AddResult> addResults) {
        this.context=context;
        this.addResults=addResults;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.resultshow,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        AddResult addResult=addResults.get(i);
        myViewHolder.name.setText(addResult.getName());
        myViewHolder.roll.setText(addResult.getRoll());
        myViewHolder.one.setText(addResult.getTgpa());
        myViewHolder.two.setText(addResult.getTgpa());
        myViewHolder.three.setText(addResult.getTgpa());
        myViewHolder.four.setText(addResult.getTgpa());
        myViewHolder.five.setText(addResult.getTgpa());
        myViewHolder.six.setText(addResult.getTgpa());
        myViewHolder.seven.setText(addResult.getTgpa());
        myViewHolder.eight.setText(addResult.getTgpa());
    }

    @Override
    public int getItemCount() {
        return addResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,roll,one,two,three,four,five,six,seven,eight;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.resultshow_name_id);
            roll=itemView.findViewById(R.id.resultshow_roll_id);
            one=itemView.findViewById(R.id.resultshow_1st_term_id);
            two=itemView.findViewById(R.id.resultshow_2nd_term_id);
            three=itemView.findViewById(R.id.resultshow_3rd_term_id);
            four=itemView.findViewById(R.id.resultshow_4th_term_id);
            five=itemView.findViewById(R.id.resultshow_5th_term_id);
            six=itemView.findViewById(R.id.resultshow_6th_term_id);
            seven=itemView.findViewById(R.id.resultshow_7th_term_id);
            eight=itemView.findViewById(R.id.resultshow_8th_term_id);
        }
    }
}

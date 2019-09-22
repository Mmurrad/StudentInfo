package com.example.studentinfo;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpdateDelete_Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> arrayList=new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_);
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploads");
        listView=findViewById(R.id.update_delete_listview_id);

        arrayAdapter=new ArrayAdapter<>(this,R.layout.sample_view,R.id.sample_text,arrayList);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value=dataSnapshot.getValue(UploadPdf.class).toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=arrayList.get(i);
                deleteData();
            }
        });
    }

    public void deleteData()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final View view=inflater.inflate(R.layout.deletepdfname,null);
        builder.setView(view);

        final EditText deletename=(EditText)view.findViewById(R.id.edittext_pdfname_id);
        final Button deletebutton=(Button)view.findViewById(R.id.button_update_id);

        builder.setTitle("Delete name ");
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=deletename.getText().toString().trim();
                deletepdf(name);
                alertDialog.dismiss();
            }
        });

    }
    private void deletepdf(String name)
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Uploads").child(name);

        databaseReference.removeValue();
    }
}

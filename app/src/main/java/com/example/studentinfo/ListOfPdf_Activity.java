package com.example.studentinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListOfPdf_Activity extends AppCompatActivity {

    private ListView pdflist;
    List<UploadPdf> uploadPdfList;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_pdf_);
        pdflist=findViewById(R.id.listofpdf_id);

        Bundle bundle=getIntent().getExtras();
        final String passvalue=bundle.getString("key");

            uploadPdfList=new ArrayList<>();
        if(passvalue.equals("showdata")){
            Viewallfiles();
            pdflist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UploadPdf uploadPdf=uploadPdfList.get(i);

                    Intent intent=new Intent();
                    intent.setType(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uploadPdf.getPdf()));
                    startActivity(intent);
                }
            });
        }
    }

    private void Viewallfiles() {
        databaseReference= FirebaseDatabase.getInstance().getReference("Uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                uploadPdfList.clear();
                for(DataSnapshot postsnapsot : dataSnapshot.getChildren())
                {

                    UploadPdf uploadPdf=postsnapsot.getValue(UploadPdf.class);
                    uploadPdfList.add(uploadPdf);
                }
                String[] uploads=new String[uploadPdfList.size()];
                for(int i=0;i<uploads.length;i++)
                {
                    uploads[i]=uploadPdfList.get(i).getName();
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),R.layout.sample_view,R.id.sample_text,uploads);
                pdflist.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

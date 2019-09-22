package com.example.studentinfo;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Student_enroll_add_data_Activity extends AppCompatActivity {

    private ImageView imageView;
    private Button choosebutton,savedatabutton;
    private EditText name,roll,school_name,college_name,home_town,birthday,mobile,email;
    private Spinner year,semister;
    private Uri  imageuri;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask storageTask;

    private static final int IMAGE_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enroll_add_data_);

        year=findViewById(R.id.year_id);
        semister=findViewById(R.id.semister_id);
        imageView=findViewById(R.id.imageview_id);
        choosebutton=findViewById(R.id.choose_button_id);
        savedatabutton=findViewById(R.id.save_student_data_id);
        name=findViewById(R.id.student_name_id);
        roll=findViewById(R.id.student_roll_id);
        school_name=findViewById(R.id.school_name_id);
        college_name=findViewById(R.id.college_name_id);
        home_town=findViewById(R.id.home_town_id);
        birthday=findViewById(R.id.date_of_birth_id);
        mobile=findViewById(R.id.mobile_number_id);
        email=findViewById(R.id.e_mail_id);

        databaseReference= FirebaseDatabase.getInstance().getReference("Student_Details");
        storageReference= FirebaseStorage.getInstance().getReference("Student_Details");

        choosebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opnenfilechooser();
            }
        });
        savedatabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(storageTask!=null && storageTask.isInProgress())
                {
                    Toast.makeText(getApplicationContext(),"Uploading in progress",Toast.LENGTH_SHORT).show();
                }
                else {
                    savedata();
                }

            }
        });

    }

    public String getFileExtention(Uri imageuri)
    {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageuri));
    }

    private void savedata() {
        final String student_name=name.getText().toString().trim();
        final String student_roll=roll.getText().toString().trim();
        final String schoolname=school_name.getText().toString().trim();
        final String collegename=college_name.getText().toString().trim();
        final String hometown=home_town.getText().toString().trim();
        final String phone=mobile.getText().toString().trim();
        final String birth=birthday.getText().toString().trim();
        final String spinner_year=year.getSelectedItem().toString().trim();
        final String spinner_semister=semister.getSelectedItem().toString().trim();
        final String mail=email.getText().toString().trim();

        if(student_name.isEmpty()){
            name.setError("Enter a name");
            name.requestFocus();
            return;
        }
        StorageReference reference=storageReference.child(System.currentTimeMillis()+"."+getFileExtention(imageuri));

        reference.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(),"Image is stored successfully",Toast.LENGTH_SHORT).show();
                Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isSuccessful());
                Uri downloaduri=uriTask.getResult();
                Student_Model student_model=new Student_Model(student_name,student_roll,schoolname,collegename,hometown,birth,phone,mail,spinner_year,spinner_semister,downloaduri.toString());
                databaseReference.child(student_name).setValue(student_model);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Image is not stored successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void opnenfilechooser() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGE_REQUEST && resultCode==RESULT_OK && data!=null &&data.getData()!=null)
        {
            imageuri=data.getData();
            Picasso.with(this).load(imageuri).into(imageView);
        }
    }
}

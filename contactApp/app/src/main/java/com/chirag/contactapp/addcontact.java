package com.chirag.contactapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class addcontact extends AppCompatActivity {
    EditText name , number , about;
    Button submit;
    File datafile;
    Uri imageuri;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ImageView circleImageView;
    private StorageReference mStorageRef;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null){
            imageuri=data.getData();
            circleImageView.setImageURI(imageuri);
            fileuploader();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        mStorageRef = FirebaseStorage.getInstance().getReference("myimages");

        firebaseDatabase=FirebaseDatabase.getInstance();
        circleImageView=findViewById(R.id.profileimage);
        databaseReference=firebaseDatabase.getReference("user");
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        about=findViewById(R.id.about);

        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()||number.getText().toString().isEmpty()){
                    name.setError("Enter name");
                    name.requestFocus();
                    number.setError("Enter number");
                }
                else{
                    final String getname , getnumber , getabout; // optional
                    getname=name.getText().toString();
                    getabout=about.getText().toString();
                    getnumber=number.getText().toString();
                   adddatatodatabse(getabout,getname,getnumber);
                }
            }
        });
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filechooser();
                circleImageView.setImageURI(imageuri);

            }
        });

    }

    private void filechooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }

    private String getExtension(Uri uri){
        if(uri==null)
            Toast.makeText(getApplicationContext(),"data lost",Toast.LENGTH_LONG).show();
    ContentResolver cr= getApplicationContext().getContentResolver();
    MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
    if(mimeTypeMap.getExtensionFromMimeType(cr.getType(uri))==null)
        Toast.makeText(getApplicationContext(),"data lost",Toast.LENGTH_LONG).show();

        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));

}
private void fileuploader(){
        StorageReference Ref= mStorageRef.child("juneja");
    Ref.putFile(imageuri)
            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // Get a URL to the uploaded content
                   // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Toast.makeText(getApplicationContext(),"file successfully uploaded",Toast.LENGTH_LONG).show();
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    Toast.makeText(getApplicationContext(),"unable to upload image"+exception.getMessage(),Toast.LENGTH_LONG).show();
                    // ...
                }
            });

}


    private void adddatatodatabse(final  String getabout, final String getname, final  String getnumber) {
        if(getabout.isEmpty()){
            final String id = databaseReference.push().getKey();
            databaseReference.child(id).child("name").setValue(getname).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        databaseReference.child(id).child("number").setValue(getnumber).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                databaseReference.child(id).child("about").setValue(getabout).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                            Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(getApplicationContext(),profile_number.class));
                                    }
                                });

                            }
                        });
                    }
                    else{

                        Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else{

        }
    }
}

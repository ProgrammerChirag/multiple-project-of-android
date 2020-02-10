package com.chirag.studentrecordwithsqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    protected EditText id , name , email , coursecount;
    protected Button view ,viewall,create , delete , update;
    protected String getname , getemail,getcoursecount;
    protected DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding id of edittext
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        coursecount=findViewById(R.id.coursecount);


        //finding id of all buttons
        view=findViewById(R.id.view);
        viewall=findViewById(R.id.viewall);
        create=findViewById(R.id.create);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);


        dataBaseHelper=new DataBaseHelper(MainActivity.this);


        //applying listener on create button
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()||email.getText().toString().isEmpty()||coursecount.getText().toString().isEmpty()){
                    name.setError("Enter name");
                    email.setError("Enter email");
                    coursecount.setError("Enter course number");
                }
                else{
                    //taking all inputs.
                    getname=name.getText().toString();
                    getemail=email.getText().toString();
                    getcoursecount=coursecount.getText().toString();


                    //intializing database class object.


                    //inserting database
                    boolean Added=dataBaseHelper.insert(getname,getemail,getcoursecount);


                    if(Added)
                        Toast.makeText(getApplicationContext(),"data successfully Added",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Applying listener on view button.
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //making an alert dialog box for setting the data for specific user.
                final AlertDialog.Builder view_data = new AlertDialog.Builder(MainActivity.this);
                view_data.setCancelable(false);



                String getid="";

                //initial the dataBaseHelper class object

                try {
                    getid=id.getText().toString();
                    Cursor cursor = dataBaseHelper.getData(getid);
                    if(cursor.moveToNext()){
                        String data="ID:"+cursor.getString(0)+"\nName:"+cursor.getString(1)+"\nEmail:"+cursor.getString(2)+"\nCourse Count:"+cursor.getString(3);
                        view_data.setMessage(data);
                    }

                }catch (SQLiteException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

                //making button and aplying listener in alert dialog box.
                view_data.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        // code after pressing yes from alert dialog box.


                    }
                });

                //showing the alert dialog box
                view_data.show();
            }
        });

        //applying listener on delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                final EditText editText= new EditText(MainActivity.this);
                editText.setBackgroundResource(R.drawable.mystyle2);
                alert.setCancelable(false);
                alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         String desired_id=editText.getText().toString();
                         try{
                        dataBaseHelper.deleteData(desired_id);
                        Toast.makeText(getApplicationContext(),"data has deleted",Toast.LENGTH_LONG).show();
                         }catch (Exception e){
                             Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_LONG).show();
                         }
                    }
                });
                alert.setTitle("Delete desired data from database");
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                alert.setTitle("Enter Unique ID:");
                editText.setHint("Enter ID Here");
                alert.setView(editText);
                alert.show();
            }
        });

        //applying listener on update button.
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                id.setEnabled(false);
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                final EditText editText= new EditText(MainActivity.this);
                editText.setBackgroundResource(R.drawable.mystyle2);
                alert.setCancelable(false);
                alert.setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String desired_id=editText.getText().toString();
                        try{
                            dataBaseHelper.update(desired_id,name.getText().toString(),email.getText().toString(),coursecount.getText().toString());
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                alert.setTitle("update desired data from database");
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                alert.setTitle("Enter Unique ID:");
                editText.setHint("Enter ID Here");
                alert.setView(editText);
                alert.show();
                id.setEnabled(true);
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=dataBaseHelper.getAllData();

                StringBuffer stringBuffer=new StringBuffer();

                if(cursor.getCount()==0){
                    showmessage("Error","no data found.");
                }
                else{
                    while (cursor.moveToNext()){
                        stringBuffer.append("ID:"+cursor.getString(0)+"\n");
                        stringBuffer.append("Name:"+cursor.getString(1)+"\n");
                        stringBuffer.append("Email:"+cursor.getString(2)+"\n");
                        stringBuffer.append("CC:"+cursor.getString(3)+"\n");
                    }
                    showmessage("all data",stringBuffer.toString());
                }
            }
        });
    }

    private void showmessage(String title, String message) {

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}

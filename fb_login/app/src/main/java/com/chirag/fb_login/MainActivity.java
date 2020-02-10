package com.chirag.fb_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    com.facebook.login.widget.LoginButton loginButton;
    CallbackManager callbackManager;
    String Default_password="123456";
    String email;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    CircleImageView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton=findViewById(R.id.loginwithfacebook);
        c=findViewById(R.id.data);
        firebaseAuth=FirebaseAuth.getInstance();
        callbackManager=CallbackManager.Factory.create();
         final String EMAIL="email";
         loginButton.setReadPermissions(Arrays.asList(EMAIL));
         loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
             @Override
             public void onSuccess(LoginResult loginResult) {
                 startActivity(new Intent(MainActivity.this,profile_page.class));

             }

             @Override
             public void onCancel() {
                 Toast.makeText(getApplicationContext(),"try again!",Toast.LENGTH_LONG).show();

             }

             @Override
             public void onError(FacebookException error) {

             }
         });
    }
    private void signin(String email, String default_password) {
        try {
            firebaseUser=firebaseAuth.getCurrentUser();
            if(firebaseUser!=null){
                Toast.makeText(getApplicationContext(),"user already exits",Toast.LENGTH_LONG).show();
                return;
            }
        }catch (Exception e){}
        firebaseAuth.signInWithEmailAndPassword(email,default_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(getApplicationContext(),"user logged in",Toast.LENGTH_LONG).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"login Success",Toast.LENGTH_LONG).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"task failed",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    AccessTokenTracker accessTokenTracker=new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
      if(currentAccessToken==null){
          Toast.makeText(getApplicationContext(),"user logged out",Toast.LENGTH_LONG).show();
      }
      else{
          userLoadProfile(currentAccessToken);
      }
        }
    };

    private void userLoadProfile(AccessToken currentAccessToken) {
        GraphRequest graphRequest=GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                     String email=object.getString("email");
                     String profileurl=object.getString("id");
                     String image_url="https://graph.facebook.com/" + profileurl + "/picture?type=normal";
                     Intent i = new Intent();
                    RequestOptions requestOptions= new RequestOptions();
                    requestOptions.dontAnimate();
                    Glide.with(MainActivity.this).load(image_url).into(c);
                    Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();
                    signin(email,Default_password);

                }catch (JSONException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        Bundle bundle=new Bundle();
        bundle.putString("fields","email,first_name,last_name,id");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
    }



    @Override
    protected void onStart() {
        try {
            firebaseUser = firebaseAuth.getCurrentUser();
            if(firebaseUser!=null){
                Toast.makeText(getApplicationContext(),"user already logged in.",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }
        super.onStart();
    }
}

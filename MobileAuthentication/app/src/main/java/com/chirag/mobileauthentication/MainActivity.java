package com.chirag.mobileauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText otp,number,otp1,otp2,otp3,otp4,otp5;
    Button get_otp;
    FirebaseAuth m_auth;
    String varify_id;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        otp=findViewById(R.id.otp);
        get_otp=findViewById(R.id.get);
        m_auth=FirebaseAuth.getInstance();
        number=findViewById(R.id.number);
        otp1=findViewById(R.id.otp1);
        otp2=findViewById(R.id.otp2);
        otp3=findViewById(R.id.otp3);
        otp4=findViewById(R.id.otp4);
        otp5=findViewById(R.id.otp5);


        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num=number.getText().toString().trim();
                if(num.isEmpty()||num.length()<10){
                    number.setError("valid number is required");
                    number.requestFocus();
                    return;
                }
                final String p_number="+91"+num;
                sendVarificationCode(p_number);
            }
        });
    }
   private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            varify_id=s;
        }
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code!=null){
                char[] arr=code.toCharArray();
                otp.setText(String.valueOf(arr[0]));
                otp1.setText(String.valueOf(arr[1]));
                otp2.setText(String.valueOf(arr[2]));
                otp3.setText(String.valueOf(arr[3]));
                otp4.setText(String.valueOf(arr[4]));
                otp5.setText(String.valueOf(arr[5]));
                verifyCode(code);
                Toast.makeText(getApplicationContext(),"code is true",Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(getApplicationContext(),"error occuring",Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };



    private void verifyCode(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(varify_id,code);
        signin(credential);
    }
    private void signin(PhoneAuthCredential credential) {
        m_auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"task success",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void sendVarificationCode(String p_number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                p_number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mcallback
        );

    }

}

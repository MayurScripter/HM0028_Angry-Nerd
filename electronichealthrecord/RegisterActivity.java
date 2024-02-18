package com.example.electronichealthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername=findViewById(R.id.editTextAppFullName);
        edPassword=findViewById(R.id.editTextAppContactNumber);
        edEmail=findViewById(R.id.editTextAppAddress);
        edConfirm=findViewById(R.id.editTextAppFees);
        btn=findViewById(R.id.buttonBookAppointment);
        tv=findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                String Email=edEmail.getText().toString();
                String Confirm=edConfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || password.length()==0|| Email.length()==0 || Confirm.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"please fill all details ",Toast.LENGTH_SHORT).show();
                }else {
                    if(password.compareTo(Confirm)==0){
                        if(isvalid(password)) {
                            db.Register(username,password,Email);
                            Toast.makeText(getApplicationContext(),"Record inserted succesfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"password must contain atleast 8 character",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"password and confirm password didn't match ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public  static  boolean isvalid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8){
            return false;
        }else{
            for(int p=0 ;p<passwordhere.length();p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            if(f1==1)
                return true;
            return false;
        }
    }
}
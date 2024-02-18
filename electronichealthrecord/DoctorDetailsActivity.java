package com.example.electronichealthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    { "Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
                    {"Doctor name : Ajit saste","Hospital address:Pimpri","EXP:5 yrs", "Mobile number:9856865253","600"},
            };
    TextView tv;
    Button btn;
    String[][] Doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDD_Title);
        btn=findViewById(R.id.buttonLTBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family physisians")==0)
            Doctor_details=doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            Doctor_details=doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            Doctor_details=doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            Doctor_details=doctor_details4;
        else
            Doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,HomeActivity.class));
            }
        });

        list= new ArrayList();
        for(int i=0;i< Doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line 1",Doctor_details[i][0]);
            item.put("line 2",Doctor_details[i][1]);
            item.put("line 3",Doctor_details[i][2]);
            item.put("line 4",Doctor_details[i][3]);
            item.put("line 5",Doctor_details[i][4]+"/-");
            list.add(item);
        }
        SimpleAdapter sa = new SimpleAdapter(this,list, R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.ListViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it= new Intent(DoctorDetailsActivity.this,HomeActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",Doctor_details[i][0]);
                it.putExtra("text3",Doctor_details[i][1]);
                it.putExtra("text4",Doctor_details[i][3]);
                it.putExtra("text5",Doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}
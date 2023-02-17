package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    EditText tid,tname,tphone;
    static int id;
    static String image,name,phone;
    ImageButton timage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
             id = bundle.getInt("id");
             image = bundle.getString("Image");
             name = bundle.getString("Name");
             phone = bundle.getString("Phone");
        }
        tid = findViewById(R.id.text_ID) ;
        tname = findViewById(R.id.text_name);
        timage = findViewById(R.id.image_second);
        tphone = findViewById(R.id.text_phone);
        tid.setText(id + " ");
        tname.setText(name);
        tphone.setText(phone);
        //timage.setImageResource(R.drawable.ic_launcher_background);


        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(tid.getText().toString());
                String name = tname.getText().toString();
                String phone = tphone.getText().toString();
                Intent intent1 =  new Intent();
                Bundle  b = new Bundle();
                b.putInt("Id",id);
                b.putString("Name",name);
                b.putString("Phone",phone);
                intent.putExtras(b);
                setResult(150,intent1);
                finish();
            }
        });
    }
}
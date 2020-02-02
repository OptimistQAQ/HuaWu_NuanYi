package com.example.lbstest.InterfaceUI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lbstest.CardView.CardMainActivity;
import com.example.lbstest.CustomRecord.CustomRecordActivity;
import com.example.lbstest.MainActivity;
import com.example.lbstest.R;

public class ZiNvJiemianActivity extends AppCompatActivity {

    private Button daohangButton;
    private Button videoButton;
    private Button cardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_nv_jiemian);

        daohangButton = findViewById(R.id.daohang_button);
        daohangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ZiNvJiemianActivity.this,MainActivity.class));
            }
        });
        videoButton = findViewById(R.id.video_button);
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ZiNvJiemianActivity.this,CustomRecordActivity.class));
            }
        });

        cardButton = findViewById(R.id.card_button);
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ZiNvJiemianActivity.this,CardMainActivity.class));
            }
        });
    }
}

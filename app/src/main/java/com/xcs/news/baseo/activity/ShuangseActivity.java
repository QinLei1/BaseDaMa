package com.xcs.news.baseo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xcs.news.baseo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuangseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuangse);
        ButterKnife.bind(this);

        ImageView imageView = findViewById(R.id.inopen_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView textView = findViewById(R.id.inopen_title);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        textView.setText(title);
    }

}

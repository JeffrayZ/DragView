package com.example.dragview;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlContent = findViewById(R.id.rl_content);
        handler.sendEmptyMessage(10);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            View view = new View(MainActivity.this);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100) ;
            view.setBackgroundColor(Color.parseColor("#ff00ff"));
            view.setLayoutParams(params);
            rlContent.addView(view);
            sendEmptyMessageDelayed(10,3000L);
        }
    };
}

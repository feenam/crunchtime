package com.example.daniel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        Button cal_btn = (Button) findViewById(R.id.select_calorie_btn);
        //listening to button
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), ThirdActivity.class);

                startActivity(nextScreen);
            }
        });
        cal_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), SecondActivity.class);

                startActivity(nextScreen);
            }
        });
    }

}

package com.example.daniel.myapplication;

/**
 * Created by daniel on 1/25/17.
 */
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;


public class SecondActivity extends Activity {

    EditText editText;
    TextView pullup, situp, squat, leglift, plank, jumpjack, pushup, cycle, walk, jog, swim, stair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_calorie);

        pullup = (TextView) findViewById(R.id.pullup_reps);
        pushup = (TextView) findViewById(R.id.pushup_reps);
        situp = (TextView) findViewById(R.id.situp_reps);
        squat = (TextView) findViewById(R.id.squats_reps);
        leglift = (TextView) findViewById(R.id.leglift_mins);
        plank = (TextView) findViewById(R.id.plank_mins);
        jumpjack = (TextView) findViewById(R.id.jumpingjack_mins);
        cycle = (TextView) findViewById(R.id.cycling_mins);
        walk = (TextView) findViewById(R.id.walking_mins);
        jog = (TextView) findViewById(R.id.jogging_mins);
        swim = (TextView) findViewById(R.id.swimming_mins);
        stair = (TextView) findViewById(R.id.stairclimb_mins);

        TextWatcher textWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                calcR();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        };

        editText = (EditText) findViewById(R.id.enter_calories_edittext);
        editText.addTextChangedListener(textWatcher);
        calcR();

        Button btn = (Button) findViewById(R.id.back_button);
        Intent i = getIntent();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });
    }
    private void calcR() throws NumberFormatException {
        Editable editable = editText.getText();
        double val = 0;

        if (editable != null && editable.length() >=1) {
            val = Double.parseDouble(editable.toString());
        }
        pushup.setText(String.format(getString(R.string.format), getString(R.string.pushup), val * 3.5, getString(R.string.Reps)));
        situp.setText(String.format(getString(R.string.format), getString(R.string.situp), val * 2.0, getString(R.string.Reps)));
        squat.setText(String.format(getString(R.string.format), getString(R.string.squat), val * 2.25, getString(R.string.Reps)));
        leglift.setText(String.format(getString(R.string.format), getString(R.string.leglift), val * .25, getString(R.string.Mins)));
        plank.setText(String.format(getString(R.string.format), getString(R.string.plank), val * .25, getString(R.string.Mins)));
        jumpjack.setText(String.format(getString(R.string.format), getString(R.string.jumpjack), val * .1, getString(R.string.Mins)));
        pullup.setText(String.format(getString(R.string.format), getString(R.string.pullup), val, getString(R.string.Reps)));
        cycle.setText(String.format(getString(R.string.format), getString(R.string.cycling), val * .12, getString(R.string.Mins)));
        walk.setText(String.format(getString(R.string.format), getString(R.string.walk), val * .2, getString(R.string.Mins)));
        jog.setText(String.format(getString(R.string.format), getString(R.string.jog), val * .12, getString(R.string.Mins)));
        swim.setText(String.format(getString(R.string.format), getString(R.string.swim), val * .13, getString(R.string.Mins)));
        stair.setText(String.format(getString(R.string.format), getString(R.string.stair), val * .15, getString(R.string.Mins)));
    }

}

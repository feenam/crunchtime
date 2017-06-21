package com.example.daniel.myapplication;

/**
 * Created by daniel on 2/6/17.
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
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ThirdActivity extends Activity implements AdapterView.OnItemSelectedListener{
    TextView resultText, cntText;
    EditText editText;

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        switch(pos) {
            case 0:
                cntText.setText(R.string.Reps);
                break;
            case 1:
                cntText.setText(R.string.Reps);
                break;
            case 2:
                cntText.setText(R.string.Reps);
                break;
            case 3:
                cntText.setText(R.string.Mins);
                break;
            case 4:
                cntText.setText(R.string.Mins);
                break;
            case 5:
                cntText.setText(R.string.Mins);
                break;
            case 6:
                cntText.setText(R.string.Reps);
                break;
            case 7:
                cntText.setText(R.string.Mins);
                break;
            case 8:
                cntText.setText(R.string.Mins);
                break;
            case 9:
                cntText.setText(R.string.Mins);
                break;
            case 10:
                cntText.setText(R.string.Mins);
                break;
            case 11:
                cntText.setText(R.string.Mins);
                break;
            default:
                cntText.setText("");
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_select_workout);

        final Spinner spinner = (Spinner) findViewById(R.id.workout_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.workout_spinner_string, R.layout.spinner_textview);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //set text watcher for input
        TextWatcher textWatcher = new TextWatcher() {
            public void afterTextChanged(Editable s) {
                calcR(spinner.getSelectedItemPosition());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        };

        resultText = (TextView) findViewById(R.id.third_activity_textview);
        cntText = (TextView) findViewById(R.id.third_act_count_text);
        editText = (EditText) findViewById(R.id.third_activity_editText);
        editText.addTextChangedListener(textWatcher);

        //back button
        Button btn = (Button) findViewById(R.id.back_button);
        Intent i = getIntent();
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });



    }
    private void calcR(int pos) throws NumberFormatException {
        Editable editable = editText.getText();
        double val = 0;
        double mul;
        double result;

        if (editable != null && editable.length() >=1) {
            val = Double.parseDouble(editable.toString());
        }
        switch(pos) {
            case 0:
                mul = 10.0/35.0;
                break;
            case 1:
                mul = 10.0/20.0;
                break;
            case 2:
                mul = 100.0/225.0;
                break;
            case 3:
                mul = 100.0/25.0;
                break;
            case 4:
                mul = 4;
                break;
            case 5:
                mul = 10;
                break;
            case 6:
                mul = 1;
                break;
            case 7:
                mul = 100.0/12.0;
                break;
            case 8:
                mul = 5;
                break;
            case 9:
                mul = 100.0/12.0;
                break;
            case 10:
                mul = 100.0/13.0;
                break;
            case 11:
                mul = 100.0/15.0;
                break;
            default:
                mul = 0;
                break;
        }
        result = val * mul;
        result = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
        resultText.setText(Double.toString(result));
    }

}

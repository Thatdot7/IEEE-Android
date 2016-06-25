package com.example.moseswan.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by moseswan on 25/06/2016.
 */
public class AdderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adder);


    }

    public void calculate(View v) {
        EditText num1 = (EditText) findViewById(R.id.editText);
        EditText num2 = (EditText) findViewById(R.id.editText2);

        TextView result = (TextView) findViewById(R.id.textView);

        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        double resultant = number1 + number2;
        result.setText(Double.toString(resultant));
    }
}

package com.example.inclassassessment1;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        TextView text = findViewById(R.id.setVariable);

        String set = "";

        CalcObject calcObject = (CalcObject) getIntent().getSerializableExtra("object");

        set += calcObject.getA() +" "+ calcObject.getOperation() +" "+ calcObject.getB() + " = ";
        double result = 0.0;
        if(calcObject.getOperation().equals("+")){
            result = calcObject.getA() + calcObject.getB();
        } else if(calcObject.getOperation().equals("-")){
            result = calcObject.getA() - calcObject.getB();
        } else if(calcObject.getOperation().equals("*")){
            result = calcObject.getA() * calcObject.getB();
        } else if(calcObject.getOperation().equals("/")){
            result = calcObject.getA() / calcObject.getB();
        }

        set += String.valueOf(result);

        text.setText(set);

        findViewById(R.id.buttonclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
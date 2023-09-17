package com.example.inclassassessment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class secondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        //Toast.makeText(getApplicationContext(), "Onto the next One", Toast.LENGTH_LONG).show();

        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                Intent intent = new Intent();
                if(radioGroup.getCheckedRadioButtonId()==R.id.Add){
                    intent.putExtra("operation", "+");
                } else if(radioGroup.getCheckedRadioButtonId()==R.id.sub){
                    intent.putExtra("operation", "-");
                } else if(radioGroup.getCheckedRadioButtonId()==R.id.multi){
                    intent.putExtra("operation", "*");
                } else if(radioGroup.getCheckedRadioButtonId()==R.id.div){
                    intent.putExtra("operation", "/");
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent();
               setResult(RESULT_CANCELED);
               finish();
            }
        });
    }
}
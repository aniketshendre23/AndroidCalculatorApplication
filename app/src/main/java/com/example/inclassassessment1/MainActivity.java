package com.example.inclassassessment1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView firstNumText;
    TextView secondNumText;
    TextView operation;
    ActivityResultLauncher<Intent> a = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK){
                        if(result.getData()!=null && result.getData().hasExtra("operation")){
                            operation.setText(result.getData().getSerializableExtra("operation").toString());
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumText = findViewById(R.id.firstNum);
        secondNumText = findViewById(R.id.secondNum);
        operation = findViewById(R.id.operationVal);

        findViewById(R.id.buttonPick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondPage.class);
                a.launch(intent);
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNumText.setText("");
                secondNumText.setText("");
            }
        });

        findViewById(R.id.buttonCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = 0.0;
                double b = 0.0;

                if(String.valueOf(firstNumText.getText()).equals("") | String.valueOf(secondNumText.getText()).equals("")){
                    Toast.makeText(getApplicationContext(), "One of the values is Empty", Toast.LENGTH_LONG).show();
                }

                if(String.valueOf(operation.getText()).equals("?")){
                    Toast.makeText(getApplicationContext(), "No opration selected", Toast.LENGTH_LONG).show();
                }

                if(String.valueOf(operation.getText()).equals("/") && String.valueOf(firstNumText.getText()).equals("0")){
                    Toast.makeText(getApplicationContext(), "cannot divide by zero", Toast.LENGTH_LONG).show();
                }

                try{
                    a = Double.parseDouble(String.valueOf(firstNumText.getText()));
                    b = Double.parseDouble(String.valueOf(secondNumText.getText()));

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "invalid text present", Toast.LENGTH_LONG).show();
                }

                String oper = String.valueOf(operation.getText());

                Intent intent = new Intent(MainActivity.this, ShowResults.class);
                CalcObject calcObject = new CalcObject(a, b, oper);
                intent.putExtra("object" , calcObject);
                startActivity(intent);


            }
        });
    }
}
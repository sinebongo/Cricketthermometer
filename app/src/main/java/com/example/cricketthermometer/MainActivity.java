package com.example.cricketthermometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button Calculate;
    TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et_number);
        Calculate = findViewById(R.id.btn);
        Message = findViewById(R.id.message);
        final DecimalFormat myformat;

        Message.setVisibility(View.GONE);
        myformat = new DecimalFormat("#0.00");

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fileds", Toast.LENGTH_SHORT).show();
                }
                else {
                    int temp = Integer.parseInt(editText.getText().toString());

                    double  number = (temp/3.0)+4;
                    String results = "The approximate temperature outside is "+myformat.format(number)+" degrees celcius";
                    Message.setText(results);
                    Message.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

package com.example.cricketchiptemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnTimer;
    TextView tvTimer;
    TextView tvTemp;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Life Cycle Event: ", "In onCreate()");

        tvTimer = findViewById(R.id.tvTimer);
        btnTimer = findViewById(R.id.btnTimer);
        etNumber = findViewById(R.id.etNumber);
        tvTemp = findViewById(R.id.tvTemp);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvTemp.setVisibility(View.GONE);

        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(14000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        tvTimer.setText("" + millisUntilFinished / 1000);
                    }
                    public void onFinish() {
                        tvTimer.setText("DONE!");
                    }
                }.start();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int chirps = Integer.parseInt(etNumber.getText().toString().trim());
                String temp = "Temperature: " + Integer.toString(chirps+40) + "\u00B0F";
                tvTemp.setText(temp);

                tvTemp.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Life Cycle Event: ", "In onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Life Cycle Event: ", "In onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Life Cycle Event: ", "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Life Cycle Event: ", "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Life Cycle Event: ", "In onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Life Cycle Event: ", "In onRestart()");
    }
}

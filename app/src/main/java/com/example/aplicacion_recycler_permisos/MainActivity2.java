package com.example.aplicacion_recycler_permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = new Intent(this, MainActivity.class);

        new CountDownTimer(5000, 1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
            startActivity(i);
            }
        }.start();
    }
}
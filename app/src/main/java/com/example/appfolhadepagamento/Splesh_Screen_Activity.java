package com.example.appfolhadepagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splesh_Screen_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarMainActivity();
            }
        }, 3500);
    }

    private void mostrarMainActivity() {
        Intent intent = new Intent(
                Splesh_Screen_Activity.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }
}
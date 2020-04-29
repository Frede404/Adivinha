package com.fred.adivinha;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void existeapp(View view) {
                finish();
                System.exit(0);
    }

    public void startapp(View view) {
        Intent intent = new Intent(this, Display_Jogo.class);
        startActivity(intent);
    }
}

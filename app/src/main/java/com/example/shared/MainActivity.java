package com.example.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btn_black, btn_red, btn_blue, btn_green, btn_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences shared = getSharedPreferences("data", Context.MODE_PRIVATE);
        textView = findViewById(R.id.tvnumber);
        btn_black = findViewById(R.id.btnBlack);
        btn_red = findViewById(R.id.btnRed);
        btn_blue = findViewById(R.id.btnBlue);
        btn_green = findViewById(R.id.btnGreen);
        btn_count = findViewById(R.id.btnCount);

        int number = shared.getInt("count",0);
        textView.setText(""+number);
        int color = shared.getInt("color", 0);
        textView.setBackgroundColor(color);

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cCount = Integer.parseInt(textView.getText().toString());
                    cCount = cCount +1;
                    textView.setText(""+cCount);
            }
        });
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });
        btn_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(getResources().getColor(R.color.black));
            }
        });
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(getResources().getColor(R.color.red));
            }
        });
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        int cCount = Integer.parseInt(textView.getText().toString());
        int cColor = ((ColorDrawable)textView.getBackground()).getColor();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count",cCount);
        editor.putInt("color",cColor);
        editor.apply();
    }
}
package com.example.ee18004.develop1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_sub);
        TextView text = (TextView)findViewById(R.id.text_view2);
        Button returnButton = findViewById(R.id.return_button);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        BufferedReader in = null;
        try {
            FileInputStream file = context.openFileInput("sample.txt");
            in = new BufferedReader(new InputStreamReader(file));
            text.setText(in.readLine());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

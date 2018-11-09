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
    //先ず、ここにファイル書き出し処理を書く

    Button returnButton = findViewById(R.id.return_button);
    TextView textView = findViewById(R.id.text_view2);

    private String fileName = "test.txt";
    String str = readFile(fileName);
    if (str != null) {
        textView.setText(str);
    } else {
        textView.setText(R.string.read_error);
    }

    public SubActivity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public String readFile(String file) throws IOException {
        setContentView(R.layout.activity_sub);

        FileInputStream fileInputStream = openFileInput("test.txt");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(fileInputStream, "UTF-8"));
        String lineBuffer;
        String test = null;
        while ((lineBuffer = reader.readLine()) != null) {
            test = lineBuffer;
        }


        return test;
    }
}

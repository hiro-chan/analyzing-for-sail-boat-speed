package com.example.ee18004.develop1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ボタンを設定
        Button sendButton = findViewById(R.id.send_button);
        // TextView の設定
        textView = findViewById(R.id.text_view);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);

                FileOutputStream fileOutputstream  = null;
                String str = "hogehoge";
                try {
                    fileOutputstream = openFileOutput("test.txt", Context.MODE_PRIVATE);
                    fileOutputstream.write(str.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


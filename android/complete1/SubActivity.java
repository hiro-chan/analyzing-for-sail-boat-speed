package com.example.ee18004.socket_chan;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ee18004.socket_chan.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubActivity extends AppCompatActivity {
    //先ず、ここにファイル書き出し処理を書く


    //TextView textView = findViewById(R.id.text_view2);
    String fileName = "test.txt";
    TextView textView = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main);

        textView = findViewById(R.id.text_view2);

        String str = readFile(fileName);



        if (str != null) {
            textView.setText(str);
        } else {
            textView.setText(R.string.read_error);
        }



        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ここにファイル呼び出し、値を別ファイルに格納する
                finish();
            }
        });
    }

    public String readFile(String file) {
        String text = null;
        try (FileInputStream fileInputStream = openFileInput(file);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(fileInputStream, "UTF-8"))) {

            String lineBuffer;
            while ((lineBuffer = reader.readLine()) != null) {
                text = lineBuffer;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


}

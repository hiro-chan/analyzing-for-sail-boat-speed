import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ee18004.socket_chan.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ボタンを設定
        Button sendButton = findViewById(R.id.send_button);
        // TextView の設定
        //TextView textView = findViewById(R.id.text_view);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                String hoge = "$GPRMC,052953.000,A,3538.9921,N,13924.1102,E,0.222,135.28,060511,,,A*6A";
                String[] line = hoge.split(",", 0);


                try {
                    FileOutputStream fileOutputstream = openFileOutput("test.txt", Context.MODE_PRIVATE);
                    fileOutputstream.write(line[7].getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */

                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);

            }
        });
    }
}

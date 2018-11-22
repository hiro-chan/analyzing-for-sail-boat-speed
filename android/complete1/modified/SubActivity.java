import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ee18004.socket_chan.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SubActivity extends AppCompatActivity {
    //先ず、ここにファイル書き出し処理を書く
    private Handler mHandler;

    //TextView textView = findViewById(R.id.text_view2);
    String fileName = "data.csv";
    TextView textView = null;
    String str = readFile(fileName);
    //String absolutePath = context.getFilesDir().getPath() + "/" + relativePath;
    //File filefile = new File(absolutePath);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_main);

        textView = findViewById(R.id.text_view2);

        mHandler = new Handler();


        for (int i = 0; i < 5; i++) {
            //String str = readFile(fileName);

            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText(R.string.read_error);
            }

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
        //String text = null;
        InputStream is = null;
        BufferedReader br = null;

        
            
        try {
            try {
                // assetsフォルダ内の sample.txt をオープンする
                is = this.getAssets().open(file);
                br = new BufferedReader(new InputStreamReader(is));

                // １行ずつ読み込み、改行を付加する
                //String str;
                for (int i = 0; i < 9; i++) {
                    str = br.readLine();
                    String[] shitei = str.split(",", 0);
                    String text = shitei[7];
                    return text;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                if (is != null) is.close();
                if (br != null) br.close();
            }
        } catch (Exception e) {
            // エラー発生時の処理
        }

        /*
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
        */
    }


}

package com.wosea.readfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView tvMyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMyText=(TextView)findViewById(R.id.tvText);
        onRead1();
        //onRead2();
    }

    public void onRead1()
    {
        try {
            InputStream in= getAssets().open("karaoke.txt");
            int size=in.available();
            byte[] buffer=new byte[size];  // cấp cho bộ nhớ đúng bằng kích thước của file,
            in.read(buffer);               //đây là cách nguy hiểm khi đọc file có kích thước 1gb trở lên
            String mystring=new String(buffer);
            tvMyText.setText(mystring);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRead2()  // Khuyên dùng
    {
        try {
            InputStream in= getAssets().open("karaoke.txt");
            byte[] buffer=new byte[10];
            int len=0;
            while((len=in.read(buffer))>0)
            {
                String mystring=new String(buffer);
                tvMyText.append(mystring);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.idgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getBundleExtra("Main");

        //Extract the data…
        String name = bundle.getString("name");
        String file = bundle.getString("file");

        Bitmap bmp = null;
        try {
            FileInputStream inputStream = this.openFileInput(file);
            bmp = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView textView = findViewById(R.id.card_name);
        textView.setText(name);

        ImageView imageView = (ImageView) findViewById(R.id.pic);
        imageView.setImageBitmap(bmp);

    }
}
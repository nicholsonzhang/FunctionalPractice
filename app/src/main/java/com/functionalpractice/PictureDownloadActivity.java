package com.functionalpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


/**
 * Created by nichol on 15/11/9.
 */
public class PictureDownloadActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = (ImageView)findViewById(R.id.download_image);
    }
}

package com.MahammadYagubli.youtubeplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnyoutube;
Button btnstand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      btnyoutube=(Button)findViewById(R.id.btnyoutubeact);
      btnstand=(Button)findViewById(R.id.btnstanalone);
        btnyoutube.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent inet=new Intent(MainActivity.this, YoutubeActivity.class);
              startActivity(inet);
          }
      });
        btnstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inet=new Intent(MainActivity.this, StandaloneActivity.class);
                startActivity(inet);
            }
        });

    }
}

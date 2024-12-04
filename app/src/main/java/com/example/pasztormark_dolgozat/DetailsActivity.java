package com.example.pasztormark_dolgozat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DetailsActivity extends  AppCompatActivity  {
    private TextView cimDetail;
    private TextView szerzoDetail;
    private TextView oldalszamDetail;
    private TextView evszamDetail;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        cimDetail = findViewById(R.id.CimDetail);
        szerzoDetail = findViewById(R.id.SzerzoDetail);
        oldalszamDetail = findViewById(R.id.OldalszamDetail);
        evszamDetail = findViewById(R.id.Evszam);
        back = findViewById(R.id.vissza);

        back.setOnClickListener(view -> {
            finish();
        });
        String cim = getIntent().getStringExtra("cim");
        String szerzo = getIntent().getStringExtra("szerzo");
        int oldalszam = getIntent().getIntExtra("oldalszam", 0);
        Random random = new Random();
        int evszam = random.nextInt(1700) + 300;

        cimDetail.setText(cim);
        szerzoDetail.setText(szerzo);
        oldalszamDetail.setText(String.valueOf(oldalszam));
        evszamDetail.setText(String.valueOf(evszam));
    }

}

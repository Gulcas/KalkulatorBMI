package com.rafal.kalkulatorbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnPolicz);
        final EditText waga = (EditText) findViewById(R.id.etWaga);
        final EditText wzrost = (EditText) findViewById(R.id.etWzrost);
        final TextView wyn = (TextView) findViewById(R.id.wynik);
        final TextView op = (TextView) findViewById(R.id.opis);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double m = new Double(waga.getText().toString());
                double w = new Double(wzrost.getText().toString());
                double bmi;

                WynikBMI obmi = new WynikBMI(m, w);
                bmi = obmi.obliczBMI(m, w);
                wyn.setText("Twoje BMI wynosi: " + bmi);

                if (bmi < 18.5) {
                    op.setText("Niedowaga");
                } else if (bmi < 25) {
                    op.setText("Waga prawidłowa");
                } else if (bmi < 30) {
                    op.setText("Nadwaga");
                } else if (bmi < 35) {
                    op.setText("Otyłość I stopnia");
                } else if (bmi < 40) {
                    op.setText("Otyłość II stopnia");
                } else {
                    op.setText("Otyłość III stopnia");
                }
            }
        });
    }
}
package com.example.mykalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextangka1,editTextangka2;
    TextView texthasil;
    Button buttontambah,buttonkurang,buttonbagi,buttonkali,buttonclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextangka1 = findViewById(R.id.editTextangka1);
        editTextangka2 = findViewById(R.id.editTextangka2);
        texthasil = findViewById(R.id.texthasil);
        buttontambah = findViewById(R.id.buttontambah);
        buttonkurang = findViewById(R.id.buttonkurang);
        buttonbagi = findViewById(R.id.buttonbagi);
        buttonkali = findViewById(R.id.buttonkali);
        buttonclear = findViewById(R.id.buttonclear);

        buttontambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextangka1.getText().length()>0 && editTextangka2.getText().length()>0){
                    double editTextangka_1= Double.parseDouble(editTextangka1.getText().toString());
                    double editTextangka_2= Double.parseDouble(editTextangka2.getText().toString());
                    double result = editTextangka_1 + editTextangka_2;
                    texthasil.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(MainActivity.this, "Mohon masukan Angka Pertama & kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextangka1.getText().length()>0 && editTextangka2.getText().length()>0){
                    double editTextangka_1= Double.parseDouble(editTextangka1.getText().toString());
                    double editTextangka_2= Double.parseDouble(editTextangka2.getText().toString());
                    double result = editTextangka_1 - editTextangka_2;
                    texthasil.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(MainActivity.this, "Mohon masukan Angka Pertama & kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextangka1.getText().length()>0 && editTextangka2.getText().length()>0){
                    double editTextangka_1= Double.parseDouble(editTextangka1.getText().toString());
                    double editTextangka_2= Double.parseDouble(editTextangka2.getText().toString());
                    double result = editTextangka_1 / editTextangka_2;
                    texthasil.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(MainActivity.this, "Mohon masukan Angka Pertama & kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextangka1.getText().length()>0 && editTextangka2.getText().length()>0){
                    double editTextangka_1= Double.parseDouble(editTextangka1.getText().toString());
                    double editTextangka_2= Double.parseDouble(editTextangka2.getText().toString());
                    double result = editTextangka_1 * editTextangka_2;
                    texthasil.setText(Double.toString(result));
                }
                else {
                    Toast.makeText(MainActivity.this, "Mohon masukan Angka Pertama & kedua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextangka1.setText("");
                editTextangka2.setText("");
                texthasil.setText("0");
                editTextangka1.requestFocus();
            }
        });
    }
}
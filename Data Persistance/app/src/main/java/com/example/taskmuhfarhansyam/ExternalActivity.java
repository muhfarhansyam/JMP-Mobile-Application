package com.example.taskmuhfarhansyam;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ExternalActivity extends AppCompatActivity {
    Button buttonbuat, buttonubah, buttonbaca, buttonhapus;
    TextView textbaca;
    public static final String filename = "namafile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        buttonbuat = findViewById(R.id.buttonbuat);
        buttonubah = findViewById(R.id.buttonubah);
        buttonbaca = findViewById(R.id.buttonbaca);
        buttonhapus = findViewById(R.id.buttonhapus);
        textbaca = findViewById(R.id.textbaca);

        buttonbuat.setOnClickListener(this::onClick);
        buttonubah.setOnClickListener(this::onClick);
        buttonbaca.setOnClickListener(this::onClick);
        buttonhapus.setOnClickListener(this::onClick);
    }
    void buatFile() {
        String cashback = "Coba Isi Data File Text";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file = new File(Environment.getExternalStorageState(),filename);
        FileOutputStream outputStream = null;

        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(cashback.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void bacaFile(){

        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, filename) ;

        if (file.exists()){
            StringBuilder text = new StringBuilder();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line =br.readLine();
                while (line!=null){
                    text.append(line);
                    line= br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error = "+ e.getMessage());
            }
            textbaca.setText(text.toString());
        }
    }

    void ubahFile() {
        String ubah = "Update Isi Data File Text";
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hapusFile(){
        File file = new File(Environment.getExternalStorageState(),filename);
        if (file.exists()){
            file.delete();
        }
    }

    public void onClick(View v){
        jalankanPerintah(v.getId());
    }

    public void jalankanPerintah (int id){
        switch (id) {
            case R.id.buttonbuat:
                buatFile();
                break;
            case R.id.buttonhapus:
                hapusFile();
                break;
            case R.id.buttonbaca:
                bacaFile();
                break;
            case R.id.buttonubah:
                ubahFile();
                break;
        }

    }
}


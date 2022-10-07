package com.example.laboratorio02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText apePT = findViewById(R.id.editTextApeP);
        EditText apeMT = findViewById(R.id.editTextApeM);
        EditText nombT = findViewById(R.id.editTextNomb);
        EditText carrT = findViewById(R.id.editTextCarrE);
        EditText colgT = findViewById(R.id.editTextColg);
        EditText fchNT = findViewById(R.id.editTextFchNa);
        TextView alerT = findViewById(R.id.textAlert);

        Button regBtn = findViewById(R.id.regBtn); //
        Button lisBtn = findViewById(R.id.listBtn);

        ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apeP = apePT.getText().toString();
                String apeM = apeMT.getText().toString();
                String nomb = nombT.getText().toString();
                String fchN = fchNT.getText().toString();
                String colg = colgT.getText().toString();
                String carr = carrT.getText().toString();
                if (!apeP.isEmpty() && !apeM.isEmpty() && !nomb.isEmpty() && !fchN.isEmpty() && !colg.isEmpty() && !carr.isEmpty()){
                    boolean flag = lista.add(new ArrayList<String>(Arrays.asList(apeP, apeM, nomb, fchN, colg, carr)));
                    if (flag) {
                        apePT.setText("");
                        apeMT.setText("");
                        nombT.setText("");
                        fchNT.setText("");
                        colgT.setText("");
                        carrT.setText("");
                        alerT.setText("Guardado Exitosamente");
                        Log.i("MainActivity", "Nuevo postulante " + lista.get(lista.size()-1));
                    }
                    else {
                        alerT.setText("Ups, ocurrió algo inesperado");
                    }
                }
                else {
                    alerT.setText("Verifique bien sus datos");
                }
            }
        });

        lisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("MainActivity", lista.size() +
                if (lista.isEmpty()) {
                    Log.i("MainActivity", "La lista esta vacía");
                    alerT.setText("La lista esta vacía");
                }
                else {
                    alerT.setText("Hay " + lista.size() + " inscritos");
                    for (ArrayList<String> list : lista) {
                        Log.i("MainActivity", list.toString());
                    }
                }
            }
        });

    }
}
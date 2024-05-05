package com.fatec.zl.amos.aula_mobile_05_exe1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private RadioButton rdUmDado;
    private RadioButton rdDoisDados;

    private RadioButton rdTresDados;
    private Button btnSortear;
    private Spinner spQtdDados;
    private TextView tvRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdUmDado = findViewById(R.id.rdUmDado);
        rdDoisDados = findViewById(R.id.rdDoisDados);
        rdTresDados = findViewById(R.id.rdTresDados);
        spQtdDados = findViewById(R.id.spQtdDados);
        tvRes = findViewById(R.id.tvRes);
        btnSortear = findViewById(R.id.btnSortear);

        preencherSpinner();

        btnSortear.setOnClickListener(op -> sortear());
    }

    private void sortear() {
        Random rand = new Random();

        Integer qtd = (Integer) spQtdDados.getSelectedItem();
        StringBuilder resultado = new StringBuilder();
        if (rdUmDado.isChecked()) {
            int primeiroAleatorio = rand.nextInt(qtd) + 1;
            resultado.append("Dado 1: ").append(primeiroAleatorio);
        } else if (rdDoisDados.isChecked()) {
            int primeiroAleatorio = rand.nextInt(qtd) + 1;
            int segundoAleatorio = rand.nextInt(qtd) + 1;
            resultado.append("Dado 1: ").append(primeiroAleatorio).append("\n");
            resultado.append("Dado 2: ").append(segundoAleatorio);
        } else if (rdTresDados.isChecked()) {
            int primeiroAleatorio = rand.nextInt(qtd) + 1;
            int segundoAleatorio = rand.nextInt(qtd) + 1;
            int terceiroAleatorio = rand.nextInt(qtd) + 1;
            resultado.append("Dado 1: ").append(primeiroAleatorio).append("\n");
            resultado.append("Dado 2: ").append(segundoAleatorio).append("\n");
            resultado.append("Dado 3: ").append(terceiroAleatorio);
        }

        tvRes.setText(resultado.toString()); // Exibindo o resultado na TextView tvRes
    }


    private void preencherSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lista);
        spQtdDados.setAdapter(adapter);
    }

}
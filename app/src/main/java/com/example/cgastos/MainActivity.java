package com.example.cgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtNomUsuario;
    private EditText txtSalida;
    private EditText txtDestino;
    private EditText txtHoraS;
    private EditText txtCombus;
    private EditText txtDistancia;
    private EditText txtHoraLl;
    private EditText txtTotal;
    private Button btnCalcTiempo;
    private Button btnCalcTotal;



    private void Iniciar(){
        txtNomUsuario = (EditText)findViewById(R.id.txtNomUsuario);
        txtSalida = (EditText)findViewById(R.id.txtSalida);
        txtDestino = (EditText)findViewById(R.id.txtDestino);
        txtHoraS = (EditText)findViewById(R.id.txtHoraS);
        txtCombus = (EditText)findViewById(R.id.txtCombus);
        txtDistancia = (EditText)findViewById(R.id.txtDistancia);
        txtHoraLl = (EditText)findViewById(R.id.txtHoraLl);
        txtTotal = (EditText)findViewById(R.id.txtTotal);

        btnCalcTiempo = (Button) findViewById(R.id.btnCalcTiempo);
       btnCalcTotal = (Button)findViewById(R.id.btnCalcTotal);

       btnCalcTiempo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               calcTiempo();
           }
       });

       btnCalcTotal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               CalcTotal();
           }
       });




    }
    private void calcTiempo(){
        int dkm = Integer.parseInt(txtDistancia.getText().toString());

        int Seg = (dkm * 3600)/100;
        int Horas = Seg /3600;
        int Min = (Seg - Horas * 3600) / 60;
        int SegR = Seg - Horas *3600 - Min *60;

        txtHoraLl.setText(String.valueOf(Horas + "Hora" + Min +"Min" + SegR + "Seg" ));
    }
    private void CalcTotal(){
        int cc = Integer.parseInt(txtCombus.getText().toString());
        int dkm = Integer.parseInt(txtDistancia.getText().toString());

        int Rendi = 13;
        int ct = (dkm / Rendi) * cc;

        txtTotal.setText(String.valueOf("$ " + ct + ".00"));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();

    }
}
package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btRerA, btRerB, btRerC, btRerD, btRerE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //faire le lien entre objets de prog et objets graphiques
        this.btRerA = (ImageButton) findViewById(R.id.IdRerA);
        this.btRerB = (ImageButton) findViewById(R.id.IdRerB);
        this.btRerC = (ImageButton) findViewById(R.id.IdRerC);
        this.btRerD = (ImageButton) findViewById(R.id.IdRerD);
        this.btRerE = (ImageButton) findViewById(R.id.IdRerE);
        //rendre les boutons écoutables
        this.btRerA.setOnClickListener(this);
        this.btRerB.setOnClickListener(this);
        this.btRerC.setOnClickListener(this);
        this.btRerD.setOnClickListener(this);
        this.btRerE.setOnClickListener(this);
        //initialiser les enquêtes
        SNCF.initialiser();
    }

    @Override
    public void onClick(View view) {
        String rer = "";
        switch (view.getId()){
            case R.id.IdRerA: rer = "rerA"; break;
            case R.id.IdRerB: rer = "rerB"; break;
            case R.id.IdRerC: rer = "rerC"; break;
            case R.id.IdRerD: rer = "rerD"; break;
            case R.id.IdRerE: rer = "rerE"; break;
        }
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);
    }
}
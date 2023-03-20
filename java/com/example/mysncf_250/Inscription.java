package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spFrequence, spAge;
    private Button btParticiper;
    private String rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.txtNom = (EditText) findViewById(R.id.IdNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtEmail = (EditText) findViewById(R.id.idEmail);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);
        this.spAge = (Spinner) findViewById(R.id.idAge);
        this.btParticiper = (Button) findViewById(R.id.idParticiper);

        this.btParticiper.setOnClickListener(this);
        if (this.getIntent().getStringExtra("rer") != null) {
            this.rer = this.getIntent().getStringExtra("rer");
        }
        //remplissage des spinners
        ArrayList<String> lesFrequences = new ArrayList<String>();
        lesFrequences.add("Quotidienne");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuel");
        lesFrequences.add("Annuel");
        //on crée un adapter qui permet de structurer l'affichage dans le spinner
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesFrequences);
        this.spFrequence.setAdapter(unAdapter);

        ArrayList<String> lesTranches = new ArrayList<String>();
        lesTranches.add("0-18 ans");
        lesTranches.add("18-35 ans");
        lesTranches.add("35-60 ans");
        lesTranches.add("60 ans et plus");
        //on crée un adapter qui permet de structurer l'affichage dans le spinner
        ArrayAdapter unAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesTranches);
        this.spAge.setAdapter(unAdapter2);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idParticiper){
            Toast.makeText(this, "Merci d'avoir accepté de répondre à cette enquête !", Toast.LENGTH_LONG).show();

            //inscription du candidat dans la SNCF
            //instancier un candidat
            Candidat unCandidat = new Candidat(
                    this.txtEmail.getText().toString(),
                    this.txtNom.getText().toString(),
                    this.txtPrenom.getText().toString(),
                    this.spFrequence.getSelectedItem().toString(),
                    this.spAge.getSelectedItem().toString()
                    );
            //on l’ajoute à l'enquête qu'il a choisi
            SNCF.getEnquete(this.rer).ajouterCandidat(unCandidat);
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("email", unCandidat.getEmail());
            this.startActivity(unIntent);
        }
    }
}
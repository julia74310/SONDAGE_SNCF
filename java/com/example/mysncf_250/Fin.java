package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResultats;
    private ImageView ivSmiley;
    private ListView lvListe;
    private Button btRetour;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.ivSmiley = (ImageView) findViewById(R.id.idSmiley);
        this.txtResultats = (TextView) findViewById(R.id.idMoyenne);

        if (this.getIntent().getStringExtra("rer") != null){
            this.rer = this.getIntent().getStringExtra("rer");
            this.email = this.getIntent().getStringExtra("email");
        }

        this.btRetour.setOnClickListener(this);

        //remplir le txtMoyenne
        float moyenne = SNCF.getEnquete(this.rer).moyenne(this.email);
        this.txtResultats.setText("Votre moyenne : " + moyenne);
        if (moyenne < 10){
            this.ivSmiley.setImageResource(R.drawable.angry);
        } else if (moyenne < 14){
            this.ivSmiley.setImageResource(R.drawable.stoic);
        } else{
            this.ivSmiley.setImageResource(R.drawable.smily);
        }

        //afficher les candidats participants dans la listeView
        ArrayList<String> lesParticipants = new ArrayList<>();
        for (Candidat unCandidat : SNCF.getEnquete(this.rer).getLesCandidats().values()){
            lesParticipants.add(unCandidat.getNom().toUpperCase() + " " + unCandidat.getPrenom() + " - " + unCandidat.moyenne() + " : " + unCandidat.getFrequence());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesParticipants);
        this.lvListe.setAdapter(unAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idRetour){
            Intent unIntent = new Intent(this, MainActivity.class);
            this.startActivity(unIntent);
        }
    }
}
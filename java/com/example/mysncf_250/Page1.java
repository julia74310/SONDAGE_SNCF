package com.example.mysncf_250;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rgService, rgPonctualite;
    private Button btSuivant;
    private String rer, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.rgService = (RadioGroup) findViewById(R.id.idService);
        this.rgPonctualite = (RadioGroup) findViewById(R.id.idPonctualite);
        this.btSuivant = (Button) findViewById(R.id.idSuivant1);
        this.btSuivant.setOnClickListener(this);

        if (this.getIntent().getStringExtra("rer") != null){
            this.rer = this.getIntent().getStringExtra("rer");
            this.email = this.getIntent().getStringExtra("email");
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.idSuivant1){
            int score = 0;
            switch (this.rgService.getCheckedRadioButtonId()){
                case R.id.idService1: score = 16; break;
                case R.id.idService2: score = 12; break;
                case R.id.idService3: score = 8; break;
            }
            //ajouter la réponse du candidat dans l'enquête en cours
            SNCF.getEnquete(this.rer).ajouterReponse("Service", score, this.email);

            switch (this.rgPonctualite.getCheckedRadioButtonId()){
                case R.id.idPonctualite1: score = 16; break;
                case R.id.idPonctualite2: score = 12; break;
                case R.id.idPonctualite3: score = 8; break;
            }

            //ajouter la réponse du candidat dans l'enquête en cours
            SNCF.getEnquete(this.rer).ajouterReponse("Ponctualite", score, this.email);

            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("email", this.email);
            this.startActivity(unIntent);
        }
    }
}
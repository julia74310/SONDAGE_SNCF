package com.example.mysncf_250;

import java.util.HashMap;

public class Candidat {

    private String email, nom, prenom, frequence, trancheAge;
    private HashMap<String, Integer> lesReponses;

    public Candidat(String email, String nom, String prenom, String frequence, String trancheAge) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.frequence = frequence;
        this.trancheAge = trancheAge;
        this.lesReponses = new HashMap<>();
    }

    public void ajouterReponse(String question, int score){
        this.lesReponses.put(question, score);
    }

    public float moyenne(){
        float m = 0;
        for(Integer score : lesReponses.values()){
            m += score;
        }
        m /= lesReponses.size();
        return m;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}

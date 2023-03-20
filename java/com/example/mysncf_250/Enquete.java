package com.example.mysncf_250;

import java.util.HashMap;

public class Enquete {

    private HashMap<String, Candidat> lesCandidats;

    public Enquete(){
        this.lesCandidats = new HashMap<>();
    }

    public void ajouterCandidat(Candidat unCandidat){
        lesCandidats.put(unCandidat.getEmail(), unCandidat);
    }

    public void ajouterReponse(String question, int score, String email){
        this.lesCandidats.get(email).ajouterReponse(question, score); //email est la clé
    }

    public float moyenne(String email){
        return this.lesCandidats.get(email).moyenne();
    }

    public Candidat getCandidat(String email){
        return this.lesCandidats.get(email);
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCandidats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}

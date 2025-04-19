package com.oxyl.coursepfback.persistance.entity;

public class PlanteEntity {

    //Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image)

    private int id_plante;
    private String nom;
    private int point_de_vie;
    private float attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private float soleil_par_seconde;
    private String effet;
    private String chemin_image;

    public PlanteEntity() {
    }

    public PlanteEntity(int id_plante, String nom, int point_de_vie, float attaque_par_seconde, int degat_attaque, int cout, float soleil_par_seconde, String effet, String chemin_image){
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public float getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(float attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public float getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public void setSoleil_par_seconde(float soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }


    public void afficherPlante(){
        System.out.println("nom : " + this.getNom() + "\n" +
                "Point de vie : " + this.getPoint_de_vie() + "\n" +
                "Attaque par seconde : " + this.getAttaque_par_seconde() + "\n" +
                "Degat attaque : " + this.getDegat_attaque() + "\n" +
                "Cout : " + this.getCout() + "\n" +
                "Soleil par seconde : " + this.getSoleil_par_seconde() + "\n" +
                "Effet : " + this.getEffet() + "\n" +
                "Chemin image : " + this.getChemin_image()+"\n\n");
    }

}

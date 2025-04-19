package com.oxyl.coursepfback.persistance.entity;

public class ZombieEntity {

    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private float attaque_par_seconde;
    private int degat_attaque;
    private float vitesse_de_deplacement;
    private String chemin_image;
    private int id_map;

    public ZombieEntity() {
    }
    public ZombieEntity(int id, String nom, int point_de_vie, float attaque_par_seconde, int degat_attaque, float vitesse_de_deplacement, String chemin_image, int id_map) {
        this.id_zombie = id;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
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

    public float getVitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }

    public void setVitesse_de_deplacement(float vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public void afficherZombie() {
        System.out.println("Zombie : " + nom + " \n Point de vie : " + point_de_vie + " \n Attaque par seconde : " + attaque_par_seconde + " \n Dégat d'attaque : " + degat_attaque + " \n Vitesse de déplacement : " + vitesse_de_deplacement + " \n Chemin de l'image : " + chemin_image + " \n Id de la map : " + id_map);
    }

}


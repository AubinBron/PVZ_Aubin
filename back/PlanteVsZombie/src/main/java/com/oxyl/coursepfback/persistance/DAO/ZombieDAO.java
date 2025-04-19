package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.ZombieEntity;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ZombieDAO extends DAO implements ZombieInterfaceDAO {

    public ZombieDAO() {
        super();
    }

    public List<ZombieEntity> getAllZombies() {
        List<ZombieEntity> zombies = new ArrayList<>();
        zombies = jdbcTemplate.query("SELECT * FROM Zombie", (rs, rownum)->{
            return new ZombieEntity(rs.getInt("id_zombie"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"));
        });
        return zombies;
    }

    public ZombieEntity getZombieById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Zombie WHERE id_zombie = ?", new Object[]{id}, (rs, rownum)->{
            return new ZombieEntity(rs.getInt("id_zombie"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"));
        });
    }

    public List<ZombieEntity> getZombiesByMapID(int mapID){
        return jdbcTemplate.query("SELECT * FROM Zombie WHERE id_map = ?", new Object[]{mapID}, (rs, rownum)->{
            return new ZombieEntity(rs.getInt("id_zombie"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getFloat("vitesse_de_deplacement"), rs.getString("chemin_image"), rs.getInt("id_map"));
        });
    }


    public void addZombie(ZombieEntity zombie){
        jdbcTemplate.update("INSERT INTO Zombie ( nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES ( ?, ?, ?, ?, ?, ?, ?)",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map()
        );
    }


    public void deleteZombie(int zombieId){
        jdbcTemplate.update("DELETE FROM Zombie WHERE id_zombie = ?", zombieId);
    }

    public void deleteZombiesByMapId(int mapId){
        jdbcTemplate.update("DELETE FROM Zombie WHERE id_map = ?", mapId);
    }

    public void updateZombie(int id, ZombieEntity zombie) {
        jdbcTemplate.update(
                "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie LIKE ?",
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_map(),
                id
        );
    }
}

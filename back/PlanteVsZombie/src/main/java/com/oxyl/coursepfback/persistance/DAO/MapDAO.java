package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.MapEntity;
import com.oxyl.coursepfback.service.model.MapModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapDAO extends DAO implements MapInterfaceDAO {

    public MapDAO() {
        super();
    }

    public List<MapEntity> getAllMaps() {
        List<MapEntity> maps;
        maps = jdbcTemplate.query("SELECT * FROM Map", (rs, rownum)->{
            return new MapEntity(rs.getInt("id_map"), rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"));
        });
        return maps;
    }

    public MapEntity getMapById(int id){

        return jdbcTemplate.queryForObject("SELECT * FROM Map WHERE id_map = ?", new Object[]{id}, (rs, rownum)->{
            return new MapEntity(rs.getInt("id_map"), rs.getInt("ligne"), rs.getInt("colonne"), rs.getString("chemin_image"));
        });
    }

    public void addMap(MapEntity map) {
        jdbcTemplate.update("INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)", map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    public void deleteMap(int id) {
        jdbcTemplate.update("DELETE FROM Map WHERE id_map = ?", id);
    }

    public void updateMap(int id, MapEntity map) {
        jdbcTemplate.update("UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?", map.getLigne(), map.getColonne(), map.getChemin_image(), id);
    }

    public List<Integer> getAllMapIds() {
        return jdbcTemplate.query("SELECT id_map FROM Map", (rs, rownum) -> rs.getInt("id_map"));
    }
}

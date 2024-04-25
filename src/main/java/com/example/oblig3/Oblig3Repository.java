package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Oblig3Repository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Film innBillett) {
    String sql = "INSERT INTO Film(filmNavn, fornavn, etternavn, tlfnr, epost, antall) VALUES(?,?,?,?,?,?)";
    db.update(sql,innBillett.getFilmNavn(),innBillett.getFornavn(),innBillett.getEtternavn(),innBillett.getTlfnr(),
            innBillett.getEpost(),innBillett.getAntall());
    }

    public List<Film> hentBilletter(){
        String sql = "SELECT * FROM Film";
        List<Film> alleBilletter = db.query(sql,new BeanPropertyRowMapper(Film.class));
        return alleBilletter;
    }

    public void slettAlle(){
        String sql = "DELETE FROM Film";
        db.update(sql);
    }

    public void slettEnkelt(int id){
        String sql = "DELETE FROM Film WHERE id=?";
        db.update(sql,id);
    }
}

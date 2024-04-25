package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class Oblig3Controller {
    @Autowired
    private Oblig3Repository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Film innBillett) {
        rep.lagreBillett(innBillett);
    }

    @GetMapping("/hentBilletter")
    public List <Film> hentListe () {
        List<Film> liste = rep.hentBilletter();
        liste.sort(new Comparator<Film>() {
            @Override
            public int compare(Film o1, Film o2) {
                return o1.getEtternavn().compareTo(o2.getEtternavn());
            }
        });
        return liste;
    }

    @GetMapping("/slettBilletter")
    public void slettBilletter() {
        rep.slettAlle();
    }

    @PostMapping("/slettEnkelt")
    public void slettBillett(int id){
        rep.slettEnkelt(id);
    }
}
package me.milija.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.milija.model.Klub;
import me.milija.model.Trener;
import me.milija.model.client.UtakmicaIgrac;

import java.util.HashSet;
import java.util.List;

@Dependent
public class KlubRepository {

    @Inject

    private EntityManager em;

    @Transactional
    public Klub dodajKlub(Klub k){
        return em.merge(k);
    }

    @Transactional
    public List<Klub> allClubs(){
        List<Klub> klubovi = em.createNamedQuery(Klub.GET_ALL_CLUBS, Klub.class).getResultList();
        for (Klub k : klubovi){
            List<Trener> treneri = em.createNamedQuery(Trener.GET_COACH_FOR_CLUB, Trener.class).setParameter("id", k.getId()).getResultList();

            k.setTreneri(new HashSet<>(treneri));
        }

        return klubovi;
    }

    @Transactional
    public UtakmicaIgrac createUtakmicaIgrac(UtakmicaIgrac ui){
        return em.merge(ui);
    }




}

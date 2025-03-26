package me.milija.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.milija.model.Klub;

@Dependent
public class KlubRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Klub dodajKlub(Klub k){
        return em.merge(k);
    }



}

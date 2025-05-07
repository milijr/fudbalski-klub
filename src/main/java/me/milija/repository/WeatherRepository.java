package me.milija.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.milija.model.Weather;

@Dependent
public class WeatherRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Weather createWeather(Weather w){
        return em.merge(w);
    }




}

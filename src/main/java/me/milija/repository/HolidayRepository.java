package me.milija.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.milija.model.Holiday;

import java.time.LocalDate;

@Dependent
public class HolidayRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Holiday createHoliday(Holiday h){
        return em.merge(h);
    }

    public boolean existsByDateAndCountryCode(LocalDate date, String countryCode) {
        Long count = (Long) em.createNamedQuery(Holiday.GET_HOLIDAY_BY_DATE_AND_COUNTRY_CODE).setParameter("date", date).setParameter("countryCode", countryCode).getSingleResult();
        return count > 0;
    }

}

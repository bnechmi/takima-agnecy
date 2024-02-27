package io.takima.agencymanagement.service;

import io.takima.agencymanagement.dao.JdbcTravelDao;
import io.takima.agencymanagement.model.Travel;

import java.sql.SQLException;
import java.util.List;

public class TravelService {

    private JdbcTravelDao jdbcTravelDao;
    public TravelService() {
        jdbcTravelDao = new JdbcTravelDao();
    }

    public List<Travel> findAvailableTravels() {
        try {
            return jdbcTravelDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

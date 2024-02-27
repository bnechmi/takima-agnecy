package io.takima.agencymanagement;

import io.takima.agencymanagement.dao.JdbcTravelDao;
import io.takima.agencymanagement.model.Airport;
import io.takima.agencymanagement.model.Travel;

import io.takima.agencymanagement.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws SQLException {
        LOGGER.info("Hello World!-00");
        System.out.println("Hello World!");

        Travel travel = Travel.builder()
                .id(10L)
                .name("name badreddine")
                .departureDate(Instant.now())
                .arrivalDate(Instant.now().plusSeconds(86400))
                .departureAirport(Airport.PARIS_CHARLES_DE_GAULLE)
                .arrivalAirport(Airport.TOKYO_HANEDA)
                .destination("destination")
                .capacity(10)
                .price(350.00)
                .build();
        System.out.println(travel);

        User user = User.builder()
                .id(1)
                .firstName("bader")
                .lastName("Nechmi")
                .email("nechmi.badreddine@gmail.com")
                .build();
        System.out.println(user);

        JdbcTravelDao jdbcTravelDao = new JdbcTravelDao();
        try {
            System.out.println("-----get all travels------");
            System.out.println(jdbcTravelDao.findAll());
            //jdbcTravelDao.save(travel);

            System.out.println("-----find Travels By Destination------");
            System.out.println(jdbcTravelDao.findTravelsByDestination("London"));

            System.out.println("-----find all travels------");

            List<Travel> travels = jdbcTravelDao.findAll();

            travels.forEach(trl -> {
                LOGGER.info("{}", trl);
            });

            System.out.println("-----find all travels from service------");

            List<Travel> travelserv = jdbcTravelDao.findAll();

            travelserv.forEach(trls -> {
                LOGGER.info("{}", trls);
            });

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

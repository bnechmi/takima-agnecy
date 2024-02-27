package io.takima.agencymanagement.dao;

import io.takima.agencymanagement.model.Airport;
import io.takima.agencymanagement.model.ConnectionManager;
import io.takima.agencymanagement.model.Travel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTravelDao {


    public void save(Travel travel) throws SQLException {
        ConnectionManager cm = ConnectionManager.INSTANCE;
        // Récupérer la connexion
        Connection connection = cm.getConnection();
        // Ecriture de la requête SQL
        PreparedStatement ps = connection.prepareStatement("INSERT INTO travel(id, name, departure_airport, " +
                " arrival_airport, departure_date, arrival_date, destination, capacity, price) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

        // Attribution des paramêtres
        ps.setLong(1, travel.getId());
        ps.setString(2, travel.getName());
        ps.setString(3, travel.getDepartureAirport().toString());
        ps.setString(4, travel.getArrivalAirport().toString());
        // Il faut transformer le Instant en Timestamp
        ps.setTimestamp(5, Timestamp.from(travel.getDepartureDate()));
        ps.setTimestamp(6, Timestamp.from(travel.getArrivalDate()));
        ps.setString(7, travel.getDestination());
        ps.setInt(8, travel.getCapacity());
        ps.setDouble(9, travel.getPrice());

        // Exécution de la requête
        ps.executeQuery();

    }

    public List<Travel> findAll() throws SQLException {

        List<Travel> getdata = new ArrayList<>();

        ConnectionManager cm = ConnectionManager.INSTANCE;
        // Récupérer la connexion
        Connection connection = cm.getConnection();
        // Ecriture de la requête SQL
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM travel");

        ResultSet rs = ps.executeQuery();
        //List<String> travels = new LinkedList<>();

        while (rs.next()) {
            Travel travel = Travel.builder()
                    .id(Long.valueOf(rs.getString("id")))
                    .name(rs.getString("name"))
                    .departureAirport(Airport.valueOf(rs.getString("departure_airport")))
                    .build();
            getdata.add(travel);
        }

        return getdata;
    }

    public Travel findTravelsByDestination(String destination) throws SQLException {

        List<Travel> getdata = new ArrayList<>();

        ConnectionManager cm = ConnectionManager.INSTANCE;
        // Récupérer la connexion
        Connection connection = cm.getConnection();
        try {
            // Ecriture de la requête SQL
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM travel WHERE destination = ?");
            ps.setString(1, destination);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Travel travel = Travel.builder()
                        .id(Long.valueOf(rs.getString("id")))
                        .name(rs.getString("name"))
                        .build();
                return  travel;
            }
        } catch (SQLException e) {
        if (connection != null) {
            connection.close();
        }
        throw e;
    }
        return  null;
    }


}

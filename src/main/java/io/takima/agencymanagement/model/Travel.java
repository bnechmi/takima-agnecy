package io.takima.agencymanagement.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Travel {
    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", destination='" + destination + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", discounts=" + discounts +
                ", participants=" + participants +
                ", waitingParticipants=" + waitingParticipants +
                '}';
    }

    private Long id;
    private String name;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Instant departureDate;
    private Instant arrivalDate;
    private String destination;
    private int capacity;
    private double price;
    private List<Discount> discounts;
    private Set<User> participants;
    private Queue<User> waitingParticipants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport  getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Instant departureDate) {
        this.departureDate = departureDate;
    }

    public Instant getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Instant arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public Queue<User> getWaitingParticipants() {
        return waitingParticipants;
    }

    public void setWaitingParticipants(Queue<User> waitingParticipants) {
        this.waitingParticipants = waitingParticipants;
    }

    public Travel(Long id, String name, Airport departureAirport, Airport arrivalAirport, Instant departureDate, Instant arrivalDate, String destination, int capacity, double price, List<Discount> discounts, Set<User> participants, Queue<User> waitingParticipants) {
        this.id = id;
        this.name = name;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.destination = destination;
        this.capacity = capacity;
        this.price = price;
        this.discounts = discounts;
        this.participants = participants;
        this.waitingParticipants = waitingParticipants;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(Travel travel) {
        return new Builder(travel);
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Airport departureAirport;
        private Airport arrivalAirport;
        private Instant departureDate;
        private Instant arrivalDate;
        private String destination;
        private int capacity;
        private double price;
        private List<Discount> discounts;
        private Set<User> participants;
        private Queue<User> waitingParticipants;

        public Builder() {
        }

        public Builder(Travel travel) {
            this.id = travel.id;
            this.name = travel.name;
            this.departureAirport = travel.departureAirport;
            this.arrivalAirport = travel.arrivalAirport;
            this.departureDate = travel.departureDate;
            this.arrivalDate = travel.arrivalDate;
            this.destination = travel.destination;
            this.capacity = travel.capacity;
            this.price = travel.price;
            this.discounts = travel.discounts;
            this.participants = travel.participants;
            this.waitingParticipants = travel.waitingParticipants;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder departureAirport(Airport departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder arrivalAirport(Airport arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder departureDate(Instant departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Builder arrivalDate(Instant arrivalDate) {
            this.arrivalDate = arrivalDate;
            return this;
        }

        public Builder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder disocunts(List<Discount> discounts) {
            this.discounts = discounts;
            return this;
        }

        public Builder participants(Set<User> participants) {
            this.participants = participants;
            return this;
        }

        public Builder waitingParticipants(Queue<User> waitingParticipants) {
            this.waitingParticipants = waitingParticipants;
            return this;
        }

        public Travel build() {
            return new Travel(id, name, departureAirport, arrivalAirport, departureDate, arrivalDate,
                    destination, capacity, price, discounts, participants, waitingParticipants);
        }
    }
}


package com.group2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transport {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private double price;
    private String dateOfFlight;
    private int numberOfSeats;
    private String departure;
    private String destiny;

    public Transport() {

    }

    public Transport(String dateOfFlight, int numberOfSeats, String departureAeroport, String destiny, double price) {
        this.dateOfFlight = dateOfFlight;
        this.numberOfSeats = numberOfSeats;
        departure = departureAeroport;
        this.destiny = destiny;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }


    @Override
    public String toString() {
        return "Transport{" +
                "dateOfFlight = " + dateOfFlight +
                ", numberOfSeats = " + numberOfSeats +
                ", DepartureAeroport = " + departure +
                ", destiny = " + destiny +
                ", Price = " + price +
                '}' + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        if (!dateOfFlight.equals(transport.dateOfFlight)) return false;
        if (!departure.equals(transport.departure)) return false;
        return destiny.equals(transport.destiny);
    }

    @Override
    public int hashCode() {
        int result = dateOfFlight.hashCode();
        result = 31 * result + departure.hashCode();
        result = 31 * result + destiny.hashCode();
        return result;
    }
}

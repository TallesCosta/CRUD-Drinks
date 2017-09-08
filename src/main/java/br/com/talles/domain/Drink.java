package br.com.talles.domain;

import java.util.Calendar;


/**
 * Class to represent an entity Drink
 *
 */
public class Drink extends Entity {
    private String name;
    private Double price;
    private Calendar manufactureDate;
    private Calendar expirationDate;

    public Drink() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Calendar getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Calendar manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }
}

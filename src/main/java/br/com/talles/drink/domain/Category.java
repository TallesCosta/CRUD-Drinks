package br.com.talles.drink.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Category entity class
 *
 */
public class Category extends Entity {
    private String name;
    private String description;
    private Boolean alcoholic;
    private Calendar maxPermanencyPeriod;
    private List<Drink> drinks = new ArrayList<>();

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(Boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public Calendar getMaxPermanencyPeriod() {
        return maxPermanencyPeriod;
    }

    public void setMaxPermanencyPeriod(Calendar maxPermanencyPeriod) {
        this.maxPermanencyPeriod = maxPermanencyPeriod;
    }
}
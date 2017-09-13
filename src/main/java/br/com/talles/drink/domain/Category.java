package br.com.talles.drink.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Category entity class
 *
 */
public class Category extends Entity {
    private String name;
    private String description;
    private Boolean alcoholic;
    private int maxPermanencyPeriod;
    private List<Drink> drinks = new ArrayList<>();

    public Category() { }

	public Category(Long id) {
		super(id);
	}

	public Category(Long id, Date createdDate, Date updatedDate, 
			String name, String description, Boolean alcoholic, int maxPermanencyPeriod) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.description = description;
		this.alcoholic = alcoholic;
		this.maxPermanencyPeriod = maxPermanencyPeriod;
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

    public int getMaxPermanencyPeriod() {
        return maxPermanencyPeriod;
    }

    public void setMaxPermanencyPeriod(int maxPermanencyPeriod) {
        this.maxPermanencyPeriod = maxPermanencyPeriod;
    }
}

package br.com.talles.drink.domain;

import java.util.Calendar;
import java.util.Date;


/**
 * Drink entity class
 *
 */
public class Drink extends Entity {
    private String name;
    private String ingredients;
    private Double price;
    private Calendar manufactureDate;
    private Calendar expirationDate;
    private Category category;
    private Supplier supplier;
    private Manufacturer manufacturer;

    public Drink() {}
	
	public Drink(Long id){
		super(id);
	}
	
	public Drink(String name, String ingredients, Double price, Calendar manufactureDate, Calendar expirationDate, 
			Category category, Manufacturer manufacturer, Supplier supplier) {
		super.setCreateDate(new Date());
		super.setUpdateDate(new Date());
	    this.name = name;
		this.ingredients = ingredients;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expirationDate = expirationDate;
		this.category = category;
		this.manufacturer = manufacturer;
		this.supplier = supplier;
	}

	public Drink(String name, String ingredients, Double aDouble, Date manufactureDate, Date expirationDate) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

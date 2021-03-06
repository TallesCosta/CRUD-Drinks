package br.com.talles.drink.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Generalized class to simplify
 * Manufacturer and Supplier classes
 */
public abstract class Company<T> extends Entity {
    private String name;
    private String registry;
    private String phone;
    private String email;
    private List<T> productsList = new ArrayList<>();

	public Company() { }

	public Company(Long id) {
		super(id);
	}

	public Company(Long id, Date createdDate, Date updatedDate, 
			String name, String registry, String phone, String email) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.registry = registry;
		this.phone = phone;
		this.email = email;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	public T getProduct(int index){
		return productsList.get(index);
	}
	
	public void addProduct(T product){
		productsList.add(product);
	}
	
	public void removeProduct(T product){
		productsList.remove(product);
	}
	
	public void removeProduct(int index){
		productsList.remove(index);
	}
	
	public void removeAllProducts(){
		productsList.clear();
	}
	
	public boolean containsProduct(T product){
		return productsList.contains(product);
	}
	
	public int sizeProducts(){
		return productsList.size();
	}
	
	public boolean hasProduct(){
		return !productsList.isEmpty();
	}
	
}

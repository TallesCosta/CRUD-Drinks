package br.com.talles.drink.domain;

import java.util.Date;

/**
 * Supplier entity class
 */
public class Supplier extends Company {

	public Supplier() { }

	public Supplier(Long id) {
		super(id);
	}

	public Supplier(Long id, Date createdDate, Date updatedDate, String name, String registry, String phone, String email) {
		super(id, createdDate, updatedDate, name, registry, phone, email);
	}
	
}

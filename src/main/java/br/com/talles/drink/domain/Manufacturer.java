package br.com.talles.drink.domain;

import java.util.Date;

/**
 * Manufacturer entity class
 */
public class Manufacturer extends Company {

	public Manufacturer() { }

	public Manufacturer(Long id) {
		super(id);
	}

	public Manufacturer(Long id, Date createdDate, Date updatedDate, String name, String registry, String phone, String email) {
		super(id, createdDate, updatedDate, name, registry, phone, email);
	}
	
}

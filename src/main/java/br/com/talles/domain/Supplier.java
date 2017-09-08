package br.com.talles.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Supplier entity class
 */
public class Supplier extends Entity {
    private String name;
    private String registry;
    private String phone;
    private String email;
    private List<Drink> productsSupplied = new ArrayList<>();

    public Supplier() {}

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
}

package br.com.talles.drink.business;

import br.com.talles.drink.domain.Entity;

public interface IStrategy {
    
    public String process(Entity entity);
    
}

package br.com.talles.business;

import br.com.talles.domain.Entity;

public interface IStrategy {
    
    public String process(Entity entity);
    
}

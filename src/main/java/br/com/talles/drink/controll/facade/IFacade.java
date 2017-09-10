package br.com.talles.drink.controll.facade;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Entity;

public interface IFacade {
    
    public Result save(Entity entity);
    
    public Result update(Entity entity);
    
    public Result delete(Entity entity);
    
    public Result select(Entity entity);
    
    public Result find(Entity entity);
    
}

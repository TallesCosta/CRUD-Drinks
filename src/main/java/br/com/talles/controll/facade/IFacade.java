package br.com.talles.controll.facade;

import br.com.talles.controll.Result;
import br.com.talles.domain.Entity;

public interface IFacade {
    
    public Result save(Entity entity);
    
    public Result update(Entity entity);
    
    public Result delete(Entity entity);
    
    public Result select(Entity entity);
    
    public Result find(Entity entity);
    
}

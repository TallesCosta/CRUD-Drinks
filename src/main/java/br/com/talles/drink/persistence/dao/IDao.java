package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Entity;
import java.util.List;

public interface IDao {
    
    public boolean save(Entity entity);
    
    public boolean update(Entity entity);
    
    public boolean delete(Entity entity);
    
    public List<Entity> select();
    
    public Entity find(Entity entity);
    
}

package br.com.talles.drink.controll.facade;

import br.com.talles.drink.business.DrinkNotBlank;
import br.com.talles.drink.business.DrinkPermanencyPeriod;
import br.com.talles.drink.business.IStrategy;
import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import br.com.talles.drink.persistence.dao.DrinkDao;
import br.com.talles.drink.persistence.dao.IDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade implements IFacade {

	private Map<String, Map<String, List<IStrategy>>> requirements;
    private Map<String, IDao> persistence;
    private Result result;
    
    private static final String SAVE = "SAVE";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String SELECT = "SELECT";
    private static final String FIND = "FIND";
	
	 public Facade() {
        String drink = Drink.class.getName();
        
        // All Strategies
        DrinkNotBlank drinkNotBlank = new DrinkNotBlank();
		DrinkPermanencyPeriod drinkPermanencyPeriod = new DrinkPermanencyPeriod();
                
        List<IStrategy> saveDrink = new ArrayList();
		saveDrink.add(drinkNotBlank);
		saveDrink.add(drinkPermanencyPeriod);
        
        List<IStrategy> updateDrink = new ArrayList();
        // Update Strategies
        
        List<IStrategy> deleteDrink = new ArrayList();
        // Delete Strategies
        
        List<IStrategy> findDrink = new ArrayList();
        // Find Strategies
        
        Map<String, List<IStrategy>> contextDrink = new HashMap();
        contextDrink.put(SAVE, saveDrink);
        contextDrink.put(UPDATE, updateDrink);
        contextDrink.put(DELETE, deleteDrink);
        contextDrink.put(FIND, findDrink);
        
        requirements = new HashMap();
        requirements.put(drink, contextDrink);
        
        persistence = new HashMap();
        persistence.put(drink, new DrinkDao());

        this.result = new Result();
    }
	
	@Override
	public Result save(Entity entity) {
		Map<String, List<IStrategy>> reqs = requirements.get(entity.getClass().getName());
        List<IStrategy> validations = reqs.get(SAVE);
        this.result = new Result();
        
        result = executeValidations(entity, validations);
        if(result.hasMsg())
            return result;
        
        IDao dao = persistence.get(entity.getClass().getName());
        boolean resultDao = dao.save(entity);
        
        if(!resultDao)
            result.addMsg("An error has occurred in the process of your operation, "
					+ "it has been noted and will be resolved soon!");
        
        return result;
	}

	@Override
	public Result update(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Result delete(Entity entity) {
		IDao dao = persistence.get(entity.getClass().getName());
        boolean resultDao = dao.delete(entity);
        
        if(!resultDao)
            result.addMsg("An error has occurred in the process of your operation, "
					+ "it has been noted and will be resolved soon!");
        
        return result;
	}

	@Override
	public Result select(Entity entity) {
		IDao dao = persistence.get(entity.getClass().getName());
        this.result = new Result();

        result.setEntities(dao.select());
        
        return result;
	}

	@Override
	public Result find(Entity entity) {
	    IDao dao = persistence.get(entity.getClass().getName());
        this.result = new Result();

	    result.setEntity(dao.find(entity));
	    return result;
	}
	
	public Result executeValidations(Entity entity, List<IStrategy> validations) {
        
        for(IStrategy validation : validations){
            result.addMsg(validation.process(entity));
            if(result.hasMsg()){
                result.setEntity(entity);
                return result;
            }
        }
        
        return result;
    }
	
}

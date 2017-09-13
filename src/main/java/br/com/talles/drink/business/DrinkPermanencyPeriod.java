
package br.com.talles.drink.business;

import br.com.talles.drink.domain.Category;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import br.com.talles.drink.persistence.dao.CategoryDao;
import java.util.Calendar;

public class DrinkPermanencyPeriod implements IStrategy {
	
	@Override
	public String process(Entity entity) {
        String msg = "";
        Drink drink = (Drink) entity;
        
		CategoryDao categoryDao = new CategoryDao();
		Category category = (Category) categoryDao.find(new Category(drink.getCategory().getId()));
		int maxPermanencyPeriod = category.getMaxPermanencyPeriod();

		Calendar manufactureDate = drink.getManufactureDate();
		manufactureDate.add(Calendar.MONTH, maxPermanencyPeriod);
        if(drink.getExpirationDate().after(manufactureDate))
            msg += "Date must be above " + maxPermanencyPeriod + " months from " + drink.getManufactureDate().getTime() + "\n";
        
        return msg;
    }
	
}

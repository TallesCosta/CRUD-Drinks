
package br.com.talles.drink.business;

import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import java.util.Calendar;

public class DrinkNotBlank implements IStrategy {

	@Override
    public String process(Entity entity) {
        String msg = "";
        Drink drink = (Drink) entity;
        
        if(drink.getName() == null || drink.getName().trim().isEmpty()){
            msg += "Name is a mandatory field!\n";
        } if(drink.getIngredients() == null || drink.getIngredients().trim().isEmpty()){
            msg += "Ingredients is a mandatory field!\n";
        } if(drink.getPrice() == null){
            msg += "Price is a mandatory field!\n";
        } if(drink.getManufactureDate() == null || drink.getManufactureDate().after(Calendar.getInstance())){
            msg += "Manufacture date is a mandatory field and should be a date up until the current date!\n";
        } if(drink.getExpirationDate() == null || drink.getManufactureDate().before(Calendar.getInstance())){
            msg += "Expiration date is a mandatory field and should be a date starting the current date!\n";
        }
        
        return msg;
    }
	
}

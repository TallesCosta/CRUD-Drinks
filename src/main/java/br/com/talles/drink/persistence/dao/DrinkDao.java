
package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrinkDao extends AbstractDao {

	@Override
	public boolean save(Entity entity) {
		openConnection();
		
		Drink drink = (Drink) entity;
        String sql = "INSERT INTO drinks(createdDate, updatedDate, name, ingredients, price, manufactureDate, expirationDate)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        		
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
			
            statement.setTimestamp(1, new java.sql.Timestamp(drink.getCreateDate().getTime()));
            statement.setTimestamp(2, new java.sql.Timestamp(drink.getUpdateDate().getTime()));
            statement.setString(3, drink.getName());
            statement.setString(4, drink.getIngredients());
			statement.setDouble(5, drink.getPrice());
			statement.setDate(6, new java.sql.Date(drink.getManufactureDate().getTimeInMillis()));
			statement.setDate(7, new java.sql.Date(drink.getExpirationDate().getTimeInMillis()));
            statement.execute();
            statement.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DrinkDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally{
			closeConnection();
		}
	}

	@Override
	public boolean update(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean delete(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Entity> select() {
		openConnection();
		
		List<Entity> drinks = new ArrayList();
        String sql = "SELECT * FROM drinks";
        
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Drink drink = new Drink();
                
                // Drink Data
                drink.setId(result.getLong("id"));
                drink.setCreateDate(result.getDate("createdDate"));
                drink.setUpdateDate(result.getDate("updatedDate"));
                drink.setName(result.getString("name"));
                drink.setIngredients(result.getString("ingredients"));
                drink.setPrice(result.getDouble("price"));
				
				Calendar calendarTemp = Calendar.getInstance();
				calendarTemp.setTime(result.getDate("manufactureDate"));
                drink.setManufactureDate(calendarTemp);
				calendarTemp.setTime(result.getDate("expirationDate"));
				drink.setExpirationDate(calendarTemp);
				                
                drinks.add(drink);
            }
            
            result.close();
            statement.close();
            
            return drinks;
        } catch(SQLException e){
            throw new RuntimeException(e);  
        } finally{
			closeConnection();
		}
	}

	@Override
	public Entity find(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}


package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Category;
import br.com.talles.drink.domain.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CategoryDao extends AbstractDao {
	
	@Override
	public boolean save(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
		
		List<Entity> categories = new ArrayList();
        String sql = "SELECT * FROM categories";
        
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Category category = new Category();
                
                // Category Data
                category.setId(result.getLong("id"));
                category.setCreateDate(result.getDate("createdDate"));
                category.setUpdateDate(result.getDate("updatedDate"));
                category.setName(result.getString("name"));
                category.setDescription(result.getString("description"));
                category.setAlcoholic(result.getBoolean("alcoholic"));
				
				Calendar maxPermanencyPeriod = Calendar.getInstance();
				maxPermanencyPeriod.setTime(result.getDate("maxPermanencyPeriod"));
                category.setMaxPermanencyPeriod(maxPermanencyPeriod);
				                
                categories.add(category);
            }
            
            result.close();
            statement.close();
			closeConnection();
			super.closeConnection();
            
            return categories;
        }catch(SQLException e){
            throw new RuntimeException(e);  
        }
	}

	@Override
	public Entity find(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}	
	
}

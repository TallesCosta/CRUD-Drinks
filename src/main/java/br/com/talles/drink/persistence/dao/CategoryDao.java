
package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Category;
import br.com.talles.drink.domain.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                category.setMaxPermanencyPeriod(result.getInt("maxPermanencyPeriod"));
				
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
		openConnection();
		Category category = (Category) entity;

		String query = "SELECT * FROM categories WHERE id = ?";

		try {
		    PreparedStatement stmt = conn.prepareStatement(query);
		    ResultSet result;

		    stmt.setLong(1, category.getId());
		    result = stmt.executeQuery();
            result.first();

            // Category Data
            category.setId(result.getLong("categories.id"));
            category.setCreateDate(result.getDate("categories.createdDate"));
            category.setUpdateDate(result.getDate("categories.updatedDate"));
            category.setName(result.getString("categories.name"));
            category.setDescription(result.getString("categories.description"));
            category.setAlcoholic(result.getBoolean("categories.alcoholic"));
			category.setMaxPermanencyPeriod(result.getInt("categories.maxPermanencyPeriod"));

            stmt.close();
            closeConnection();

            return category;
		} catch (SQLException e) {
		    throw new RuntimeException(e);
        }
	}	
	
}

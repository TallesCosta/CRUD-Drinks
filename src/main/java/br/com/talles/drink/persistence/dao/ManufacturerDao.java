
package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Manufacturer;
import br.com.talles.drink.domain.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDao extends AbstractDao {

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
		
		List<Entity> manufacturers = new ArrayList();
        String sql = "SELECT * FROM manufacturers";
        
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Manufacturer manufacturer = new Manufacturer();
                
                // Manufacturer Data
                manufacturer.setId(result.getLong("id"));
                manufacturer.setCreateDate(result.getDate("createdDate"));
                manufacturer.setUpdateDate(result.getDate("updatedDate"));
                manufacturer.setName(result.getString("name"));
                manufacturer.setRegistry(result.getString("registry"));
                manufacturer.setPhone(result.getString("phone"));
				manufacturer.setEmail(result.getString("email"));
				
                manufacturers.add(manufacturer);
            }
            
            result.close();
            statement.close();
			closeConnection();
			super.closeConnection();
            
            return manufacturers;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
	}

	@Override
	public Entity find(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}

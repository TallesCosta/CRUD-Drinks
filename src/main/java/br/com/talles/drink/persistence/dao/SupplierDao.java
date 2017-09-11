
package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Entity;
import br.com.talles.drink.domain.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao extends AbstractDao {

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
		
		List<Entity> suppliers = new ArrayList();
        String sql = "SELECT * FROM suppliers";
        
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                Supplier supplier = new Supplier();
                
                // Supplier Data
                supplier.setId(result.getLong("id"));
                supplier.setCreateDate(result.getDate("createdDate"));
                supplier.setUpdateDate(result.getDate("updatedDate"));
                supplier.setName(result.getString("name"));
                supplier.setRegistry(result.getString("registry"));
                supplier.setPhone(result.getString("phone"));
				supplier.setEmail(result.getString("email"));
				
                suppliers.add(supplier);
            }
            
            result.close();
            statement.close();
			closeConnection();
			super.closeConnection();
            
            return suppliers;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
	}

	@Override
	public Entity find(Entity entity) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}

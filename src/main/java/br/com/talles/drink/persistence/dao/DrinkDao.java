package br.com.talles.drink.persistence.dao;

import br.com.talles.drink.domain.Category;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import br.com.talles.drink.domain.Manufacturer;
import br.com.talles.drink.domain.Supplier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrinkDao extends AbstractDao {

	@Override
	public boolean save(Entity entity) {
		openConnection();

		Drink drink = (Drink) entity;
		String sql = "INSERT INTO drinks(createdDate, updatedDate, name, ingredients, price, manufactureDate, expirationDate, "
				+ "id_category, id_manufacturer, id_supplier)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setTimestamp(1, new java.sql.Timestamp(drink.getCreateDate().getTime()));
			statement.setTimestamp(2, new java.sql.Timestamp(drink.getUpdateDate().getTime()));
			statement.setString(3, drink.getName());
			statement.setString(4, drink.getIngredients());
			statement.setDouble(5, drink.getPrice());
			statement.setTimestamp(6, new java.sql.Timestamp(drink.getManufactureDate().getTime().getTime()));
			statement.setTimestamp(7, new java.sql.Timestamp(drink.getExpirationDate().getTime().getTime()));
			statement.setLong(8, drink.getCategory().getId());
			statement.setLong(9, drink.getManufacturer().getId());
			statement.setLong(10, drink.getSupplier().getId());
			statement.execute();
			statement.close();

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DrinkDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			closeConnection();
		}
	}

	@Override
	public boolean update(Entity entity) {
		openConnection();
		Drink drink = (Drink) entity;
		String query = "UPDATE drinks SET " +
                "updatedDate = ?, " +
                "name = ?, " +
                "ingredients = ?, " +
                "price = ?, " +
                "manufactureDate = ?, " +
                "expirationDate = ?, " +
                "id_category = ?, " +
                "id_manufacturer = ?, " +
                "id_supplier = ? " +
                "WHERE drinks.id = ?";
		try {
		    PreparedStatement stmt = conn.prepareStatement(query);
		    stmt.setTimestamp(1, new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		    stmt.setString(2, drink.getName());
		    stmt.setString(3, drink.getIngredients());
		    stmt.setDouble(4, drink.getPrice());

		    java.sql.Date dateRecord = new java.sql.Date(drink.getManufactureDate().getTimeInMillis());
		    stmt.setDate(5, dateRecord);

		    dateRecord = new java.sql.Date(drink.getExpirationDate().getTimeInMillis());
		    stmt.setDate(6, dateRecord);

		    stmt.setLong(7, drink.getCategory().getId());
		    stmt.setLong(8, drink.getManufacturer().getId());
		    stmt.setLong(9, drink.getSupplier().getId());
		    stmt.setLong(10, drink.getId());
		    stmt.execute();
		    stmt.close();

		    return true;
        } catch (SQLException e) {
            Logger.getLogger(DrinkDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
		    closeConnection();
        }
	}

	@Override
	public boolean delete(Entity entity) {
		openConnection();

		Drink drink = (Drink) entity;
		String sql = "DELETE FROM drinks "
				+ "WHERE id = ?";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, drink.getId());
			statement.execute();
			statement.close();

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DrinkDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			closeConnection();
		}
	}

	@Override
	public List<Entity> select() {
		openConnection();

		List<Entity> drinks = new ArrayList();
		String sql = "SELECT * FROM drinks d "
				+ "INNER JOIN categories c ON d.id_category = c.id "
				+ "INNER JOIN manufacturers m ON d.id_manufacturer = m.id "
				+ "INNER JOIN suppliers s ON d.id_supplier = s.id";

		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Drink drink = new Drink();

				// Drink Data
				drink.setId(result.getLong("drinks.id"));
				drink.setCreateDate(result.getDate("drinks.createdDate"));
				drink.setUpdateDate(result.getDate("drinks.updatedDate"));
				drink.setName(result.getString("drinks.name"));
				drink.setIngredients(result.getString("drinks.ingredients"));
				drink.setPrice(result.getDouble("drinks.price"));

				Calendar calendarTemp = Calendar.getInstance();
				calendarTemp.setTime(result.getDate("drinks.manufactureDate"));
				drink.setManufactureDate(calendarTemp);
				calendarTemp = Calendar.getInstance();
				calendarTemp.setTime(result.getDate("drinks.expirationDate"));
				drink.setExpirationDate(calendarTemp);

				// Category Data
				Category category = new Category();
				category.setId(result.getLong("categories.id"));
				category.setCreateDate(result.getDate("categories.createdDate"));
				category.setUpdateDate(result.getDate("categories.updatedDate"));
				category.setName(result.getString("categories.name"));
				category.setDescription(result.getString("categories.description"));
				category.setAlcoholic(result.getBoolean("categories.alcoholic"));
				category.setMaxPermanencyPeriod(result.getInt("categories.maxPermanencyPeriod"));

				// Manufacturer Data
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setId(result.getLong("manufacturers.id"));
				manufacturer.setCreateDate(result.getDate("manufacturers.createdDate"));
				manufacturer.setUpdateDate(result.getDate("manufacturers.updatedDate"));
				manufacturer.setName(result.getString("manufacturers.name"));
				manufacturer.setRegistry(result.getString("manufacturers.registry"));
				manufacturer.setPhone(result.getString("manufacturers.phone"));
				manufacturer.setEmail(result.getString("manufacturers.email"));

				// Supplier Data
				Supplier supplier = new Supplier();
				supplier.setId(result.getLong("suppliers.id"));
				supplier.setCreateDate(result.getDate("suppliers.createdDate"));
				supplier.setUpdateDate(result.getDate("suppliers.updatedDate"));
				supplier.setName(result.getString("suppliers.name"));
				supplier.setRegistry(result.getString("suppliers.registry"));
				supplier.setPhone(result.getString("suppliers.phone"));
				supplier.setEmail(result.getString("suppliers.email"));

				drink.setCategory(category);
				drink.setManufacturer(manufacturer);
				drink.setSupplier(supplier);

				drinks.add(drink);
			}

			result.close();
			statement.close();

			return drinks;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
	}

	@Override
	public Entity find(Entity entity) {
		openConnection();
		Drink drink = (Drink) entity;

		String query = "SELECT * FROM drinks d "
				+ "INNER JOIN categories c ON d.id_category = c.id "
				+ "INNER JOIN manufacturers m ON d.id_manufacturer = m.id "
				+ "INNER JOIN suppliers s ON d.id_supplier = s.id "
				+ "WHERE d.id = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet result;

			stmt.setLong(1, drink.getId());
			result = stmt.executeQuery();
			result.first();

			// Drink Data
			drink.setId(result.getLong("drinks.id"));
			drink.setCreateDate(result.getDate("drinks.createdDate"));
			drink.setUpdateDate(result.getDate("drinks.updatedDate"));
			drink.setName(result.getString("drinks.name"));
			drink.setIngredients(result.getString("drinks.ingredients"));
			drink.setPrice(result.getDouble("drinks.price"));

			Calendar calendarTemp = Calendar.getInstance();
			calendarTemp.setTime(result.getDate("drinks.manufactureDate"));
			drink.setManufactureDate(calendarTemp);
			calendarTemp = Calendar.getInstance();
			calendarTemp.setTime(result.getDate("drinks.expirationDate"));
			drink.setExpirationDate(calendarTemp);

			// Category Data
			Category category = new Category();
			category.setId(result.getLong("categories.id"));
			category.setCreateDate(result.getDate("categories.createdDate"));
			category.setUpdateDate(result.getDate("categories.updatedDate"));
			category.setName(result.getString("categories.name"));
			category.setDescription(result.getString("categories.description"));
			category.setAlcoholic(result.getBoolean("categories.alcoholic"));
			category.setMaxPermanencyPeriod(result.getInt("categories.maxPermanencyPeriod"));

			// Manufacturer Data
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setId(result.getLong("manufacturers.id"));
			manufacturer.setCreateDate(result.getDate("manufacturers.createdDate"));
			manufacturer.setUpdateDate(result.getDate("manufacturers.updatedDate"));
			manufacturer.setName(result.getString("manufacturers.name"));
			manufacturer.setRegistry(result.getString("manufacturers.registry"));
			manufacturer.setPhone(result.getString("manufacturers.phone"));
			manufacturer.setEmail(result.getString("manufacturers.email"));

			// Supplier Data
			Supplier supplier = new Supplier();
			supplier.setId(result.getLong("suppliers.id"));
			supplier.setCreateDate(result.getDate("suppliers.createdDate"));
			supplier.setUpdateDate(result.getDate("suppliers.updatedDate"));
			supplier.setName(result.getString("suppliers.name"));
			supplier.setRegistry(result.getString("suppliers.registry"));
			supplier.setPhone(result.getString("suppliers.phone"));
			supplier.setEmail(result.getString("suppliers.email"));

			drink.setCategory(category);
			drink.setManufacturer(manufacturer);
			drink.setSupplier(supplier);

			stmt.close();

			return drink;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection();
		}
	}

}

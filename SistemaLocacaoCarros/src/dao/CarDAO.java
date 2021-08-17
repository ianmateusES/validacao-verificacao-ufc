package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class CarDAO {
	private Connection connection;
	
	public CarDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean create(Car car) {
		String sql = "INSERT INTO cars (model, license_plate, color, year, fine_amount)" + 
					 "VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, car.getModel());
			stmt.setString(2, car.getLicense_plate());
			stmt.setString(3, car.getColor());
			stmt.setInt(4, car.getYear());
			stmt.setFloat(5, car.getFine_amount());
			
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Car> list() {
		String sql = "SELECT * FROM cars AS c;";
		List<Car> cars = new ArrayList<Car>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setModel(rs.getString("model"));
				car.setLicense_plate(rs.getString("license_plate"));
				car.setColor(rs.getString("color"));
				car.setYear(rs.getInt("year"));
				car.setFine_amount(rs.getFloat("fine_amount"));
				car.setAvailable(rs.getBoolean("available"));
				
				cars.add(car);
			}
			stmt.close();
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cars;
	}
	
	public Car search_license_plate(String license_plate) {
		String sql = "SELECT * FROM cars AS c WHERE c.license_plate = ?;";
		Car car = new Car();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, license_plate);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				car.setId(rs.getInt("id"));
				car.setModel(rs.getString("model"));
				car.setLicense_plate(rs.getString("license_plate"));
				car.setColor(rs.getString("color"));
				car.setYear(rs.getInt("year"));
				car.setFine_amount(rs.getFloat("fine_amount"));
				car.setAvailable(rs.getBoolean("available"));
			}
			stmt.close();
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}
	
	public List<Car> list_available(boolean available) {
		String sql = "SELECT * FROM cars AS c WHERE c.available = ?;";
		List<Car> cars = new ArrayList<Car>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, available);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setModel(rs.getString("model"));
				car.setLicense_plate(rs.getString("license_plate"));
				car.setColor(rs.getString("color"));
				car.setYear(rs.getInt("year"));
				car.setFine_amount(rs.getFloat("fine_amount"));
				car.setAvailable(rs.getBoolean("available"));
				
				cars.add(car);
			}
			stmt.close();
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cars;
	}
	
	public boolean update_fine_amount(String license_plate, float fine_amount) {
		String sql = "UPDATE cars SET fine_amount = ? WHERE license_plate = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setFloat(1, fine_amount);
			stmt.setString(2, license_plate);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean update_available(String license_plate, boolean available) {
		String sql = "UPDATE cars SET available = ? WHERE license_plate = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, available);
			stmt.setString(2, license_plate);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean delete(String license_plate) {
		String sql = "DELETE FROM cars WHERE license_plate = ?";
		try {
			PreparedStatement stmt =  connection.prepareStatement(sql);
			stmt.setString(1, license_plate);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
			
		} catch(SQLException e) {
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

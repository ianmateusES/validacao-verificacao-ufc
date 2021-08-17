package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Rental;

public class RentalDAO {
	private Connection connection;
	
	public RentalDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean create(Rental rental) {
		String sql = "INSERT INTO rentals (client_cpf, car_license_plate)" + 
					 "VALUES (?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, rental.getClient_cpf());
			stmt.setString(2, rental.getCar_license_plate());
			
			
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
	
	public List<Rental> list() {
		String sql = "SELECT * FROM rentals AS r;";
		List<Rental> rentals = new ArrayList<Rental>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setId(rs.getInt("id"));
				rental.setClient_cpf(rs.getString("client_cpf"));
				rental.setCar_license_plate(rs.getString("car_license_plate"));
				rental.setRented(rs.getBoolean("rented"));
				rental.setDate_rental(rs.getDate("date_rental"));
				
				rentals.add(rental);
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
		return rentals;
	}
	
	public List<Rental> search_rented(boolean rented) {
		String sql = "SELECT * FROM rentals AS r WHERE r.rented = ?;";
		List<Rental> rentals = new ArrayList<Rental>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, rented);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setId(rs.getInt("id"));
				rental.setClient_cpf(rs.getString("client_cpf"));
				rental.setCar_license_plate(rs.getString("car_license_plate"));
				rental.setRented(rs.getBoolean("rented"));
				rental.setDate_rental(rs.getDate("date_rental"));
				
				rentals.add(rental);
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
		return rentals;
	}
	
	public List<Rental> search_client_rented(String client_cpf, boolean rented) {
		String sql = "SELECT * FROM rentals AS r WHERE r.client_cpf = ? AND r.rented = ?;";
		List<Rental> rentals = new ArrayList<Rental>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, client_cpf);
			stmt.setBoolean(2, rented);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setId(rs.getInt("id"));
				rental.setClient_cpf(rs.getString("client_cpf"));
				rental.setCar_license_plate(rs.getString("car_license_plate"));
				rental.setRented(rs.getBoolean("rented"));
				rental.setDate_rental(rs.getDate("date_rental"));
				
				rentals.add(rental);
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
		return rentals;
	}
	
	public Rental search_license_plate_rented(String license_plate) {
		String sql = "SELECT * FROM rentals AS r WHERE r.car_license_plate = ? AND r.rented = TRUE;";
		Rental rental = new Rental();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, license_plate);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				rental.setId(rs.getInt("id"));
				rental.setClient_cpf(rs.getString("client_cpf"));
				rental.setCar_license_plate(rs.getString("car_license_plate"));
				rental.setRented(rs.getBoolean("rented"));
				rental.setDate_rental(rs.getDate("date_rental"));
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
		return rental;
	}
	
	public boolean update_rented(int id, boolean rented) {
		String sql = "UPDATE rentals SET rented = ? WHERE id = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, rented);
			stmt.setInt(2, id);
			
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

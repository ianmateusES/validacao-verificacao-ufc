package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Client;

public class ClientDAO {
	private Connection connection;
	
	public ClientDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean create(Client client) {
		String sql = "INSERT INTO clients (name, address, contact, cpf)" + 
					 "VALUES (?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getAddress());
			stmt.setString(3, client.getContact());
			stmt.setString(4, client.getCpf());
			
			
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
	
	public List<Client> list() {
		String sql = "SELECT * FROM clients AS c;";
		List<Client> clients = new ArrayList<Client>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setAddress(rs.getString("address"));
				client.setContact(rs.getString("contact"));
				client.setCpf(rs.getString("cpf"));
				
				clients.add(client);
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
		return clients;
	}
	
	public Client search_cpf(String cpf) {
		String sql = "SELECT * FROM clients AS c WHERE c.cpf = ?;";
		Client client = new Client();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setAddress(rs.getString("address"));
				client.setContact(rs.getString("contact"));
				client.setCpf(rs.getString("cpf"));
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
		return client;
	}
	
	public boolean update(String cpf, String name, String address) {
		String sql = "UPDATE clients SET name = ?, address= ? WHERE cpf = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setString(3, cpf);
			
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
	
	public boolean delete(String cpf) {
		String sql = "DELETE FROM clients WHERE cpf = ?";
		try {
			PreparedStatement stmt =  connection.prepareStatement(sql);
			stmt.setString(1, cpf);
			
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

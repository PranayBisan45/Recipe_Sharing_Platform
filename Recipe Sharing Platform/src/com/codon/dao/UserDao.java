package com.codon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.codon.model.User;

public class UserDao {
	public boolean registration(User user) {
		String query = "INSERT INTO \"User\" (\"User_Name\",\"Password\",\"Mobile_Number\",\"Email\") VALUES (?,?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getMobileNumber());
			statement.setString(4, user.getEmail());
			
			int rows = statement.executeUpdate();
			return rows>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public User Login(String username, String password) {
		String query = "SELECT * FROM \"User\" WHERE \"User_Name\"=? AND \"Password\"=?";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("User_Name"));
				user.setPassword(rs.getString("password"));
				user.setMobileNumber(rs.getString("Mobile_Number"));
				user.setEmail(rs.getString("email"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isValidUser(String username, String email) {
		String query = "SELECT * FROM \"User\" WHERE \"User_Name\"=? AND \"Email\"=?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, username);
				statement.setString(2, email);
				
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {
					return true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String Password(String user) {
		String query = "SELECT \"Password\" FROM \"User\" WHERE \"User_Name\"=?";
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, user);
				
				ResultSet rs = statement.executeQuery();
				
				if (rs.next()) {
		            return rs.getString("Password");
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
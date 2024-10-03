package com.codon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codon.model.Comment;

public class InteractionDao {
	public boolean addLikes(int Recipe_ID, String User_Name) {
		String query = "INSERT INTO \"Likes\" (\"Recipe_ID\",\"User_Name\") VALUES (?,?)";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			statement.setString(2, User_Name);
			
			int rows = statement.executeUpdate();
			return rows>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLiked(int Recipe_ID, String User_Name) {
		String query = "SELECT * FROM \"Likes\" WHERE \"Recipe_ID\"=? AND \"User_Name\"=?";
		
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			statement.setString(2, User_Name);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addComment(int Recipe_ID,String User_Name,String Comment) {
		String query = "INSERT INTO \"Comments\" (\"Recipe_ID\",\"User_Name\",\"Comment\") VALUES (?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			statement.setString(2, User_Name);
			statement.setString(3, Comment);
				
			int rows = statement.executeUpdate();
			return rows>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getTotalLikes(int Recipe_ID) {
		String query = "SELECT COUNT(*) FROM \"Likes\" WHERE \"Recipe_ID\"=?";
		int count=0;
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Comment> getTotalComments(int Recipe_ID) {
		String query = "SELECT * FROM \"Comments\" WHERE \"Recipe_ID\"=?";
		List<Comment> comments = new ArrayList<>();
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setUser_Name(rs.getString("User_Name"));
				comment.setComment(rs.getString("Comment"));
				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comments;
	}
	
	public String getUserName(int Recipe_ID) {
		String query = "SELECT \"User_Name\" FROM \"Recipe\" WHERE \"Recipe_ID\"=?";
		String UserName=null;
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, Recipe_ID);
				
				ResultSet rs = statement.executeQuery();
				
				if (rs.next()) {
		            UserName = rs.getString("User_Name");
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		return UserName;
	}
	
	public String getEmailID(String User_Name) {
		String query = "SELECT \"Email\" FROM \"User\" WHERE \"User_Name\"=?";
		String email=null;
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, User_Name);
				
				ResultSet rs = statement.executeQuery();
				
				if (rs.next()) {
		            email = rs.getString("Email");
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		return email;
	}
	
	public String getRecipeName(int Recipe_ID) {
		String query = "SELECT \"Recipe_Title\" FROM \"Recipe\" WHERE \"Recipe_ID\"=?";
		String RecipeName=null;
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, Recipe_ID);
				
				ResultSet rs = statement.executeQuery();
				
				if (rs.next()) {
		            RecipeName = rs.getString("Recipe_Title");
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
		return RecipeName;
	}
}
package com.codon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codon.model.Favourite;
import com.codon.model.Recipe;

public class RecipeDao {
	
	public boolean saveRecipe(String title,String ingredients, String Description, String User_Name, String Cooking_Time, String difficulty_Level) {
		String query = "INSERT INTO \"Recipe\" (\"Recipe_Title\",\"Ingredients\",\"Description\",\"User_Name\","
				+ "\"Cooking_Time\",\"Difficulty_Level\") VALUES(?,?,?,?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, title);
			statement.setString(2, ingredients);
			statement.setString(3, Description);
			statement.setString(4, User_Name);
			statement.setString(5, Cooking_Time);
			statement.setString(6, difficulty_Level);
			
			int rows = statement.executeUpdate();
			return rows>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Recipe> getRecipeByName(String User_Name) {
		List<Recipe> recipes = new ArrayList<>();
		
        String query = "SELECT * FROM \"Recipe\" WHERE \"User_Name\"=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setString(1, User_Name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Recipe recipe = new Recipe();
                
                recipe.setRecipeID(rs.getInt("Recipe_ID"));
                recipe.setTitle(rs.getString("Recipe_Title"));
                recipe.setIngredients(rs.getString("Ingredients"));
                recipe.setdiscription(rs.getString("Description"));
                recipe.setUser_Name(rs.getString("User_Name"));
                recipe.setCooking_Time(rs.getString("Cooking_Time"));
                recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
                recipes.add(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
	}
	
	public List<Recipe> filterByCookingTime(String Cooking_Time) {
		String query = "SELECT * FROM \"Recipe\" WHERE \"Cooking_Time\"=?";
		List<Recipe> recipes = new ArrayList<>();
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, Cooking_Time);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Recipe recipe = new Recipe();
				
				recipe.setTitle(rs.getString("Recipe_Title"));
                recipe.setIngredients(rs.getString("Ingredients"));
                recipe.setdiscription(rs.getString("Description"));
                recipe.setUser_Name(rs.getString("User_Name"));
                recipe.setCooking_Time(rs.getString("Cooking_Time"));
                recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
                recipes.add(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipes;
	}
	
	public List<Recipe> filterByDifficultyLevel(String Difficulty_Level) {
		String query = "SELECT * FROM \"Recipe\" WHERE \"Difficulty_Level\"=?";
		List<Recipe> recipes = new ArrayList<>();
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, Difficulty_Level);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					Recipe recipe = new Recipe();
					
					recipe.setTitle(rs.getString("Recipe_Title"));
	                recipe.setIngredients(rs.getString("Ingredients"));
	                recipe.setdiscription(rs.getString("Description"));
	                recipe.setUser_Name(rs.getString("User_Name"));
	                recipe.setCooking_Time(rs.getString("Cooking_Time"));
	                recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
	                recipes.add(recipe);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return recipes;
	}
	
	public void updateRecipe(Recipe recipe) {
		String query = "UPDATE \"Recipe\" SET \"Recipe_Title\"=?, \"Ingredients\"=?,\"Description\"=?, \"Cooking_Time\"=?,\"Difficulty_Level\"=?"
				+ "WHERE \"Recipe_ID\"=?";
				
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, recipe.getTitle());
			statement.setString(2, recipe.getIngredients());
			statement.setString(3, recipe.getdiscription());
			statement.setString(4, recipe.getCooking_Time());
			statement.setString(5, recipe.getDifficulty_Level());
			statement.setInt(6, recipe.getRecipeID());
			
			statement.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Recipe getRecipeById(int Recipe_ID) {
		String query = "SELECT * FROM \"Recipe\" WHERE \"Recipe_ID\"=?";
		Recipe recipe = new Recipe();
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				recipe.setRecipeID(rs.getInt("Recipe_ID"));
				recipe.setTitle(rs.getString("Recipe_Title"));
				recipe.setIngredients(rs.getString("Ingredients"));
				recipe.setdiscription(rs.getString("Description"));
				recipe.setCooking_Time(rs.getString("Cooking_Time"));
				recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
				recipe.setUser_Name(rs.getString("User_Name"));
			}
			return recipe;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteRecipe(int Recipe_ID) {
		String query = "DELETE FROM \"Recipe\" WHERE \"Recipe_ID\"=?";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Recipe_ID);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM \"Recipe\"";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

        	ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Recipe recipe = new Recipe();
                
                recipe.setRecipeID(rs.getInt("Recipe_ID"));
                recipe.setTitle(rs.getString("Recipe_Title"));
                recipe.setIngredients(rs.getString("Ingredients"));
                recipe.setdiscription(rs.getString("Description"));
                recipe.setUser_Name(rs.getString("User_Name"));
                recipe.setCooking_Time(rs.getString("Cooking_Time"));
                recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
                recipes.add(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
	}
	
	public List<Recipe> searchRecipe(String keyword) {
		String query = "SELECT * FROM \"Recipe\" WHERE \"Recipe_Title\" LIKE ? OR \"Ingredients\" LIKE ? OR \"Description\" LIKE ?";
		List<Recipe> recipes = new ArrayList<>();
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			
			String searchKeyword = "%"+keyword+"%";
			statement.setString(1, searchKeyword);
			statement.setString(2, searchKeyword);
			statement.setString(3, searchKeyword);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Recipe recipe = new Recipe();
				
				recipe.setTitle(rs.getString("Recipe_Title"));
				recipe.setIngredients(rs.getString("Ingredients"));
                recipe.setdiscription(rs.getString("Description"));
                recipe.setUser_Name(rs.getString("User_Name"));
                recipe.setCooking_Time(rs.getString("Cooking_Time"));
                recipe.setDifficulty_Level(rs.getString("Difficulty_Level"));
                recipes.add(recipe);
			}
		} catch (Exception e) {
            e.printStackTrace();
        }
		return recipes;
	}
	
	public boolean favouriteRecipe(Favourite favourite) {
		String query = "INSERT INTO \"Favourite\" (\"Recipe_Title\",\"Ingredients\",\"Description\",\"Author_Name\","
				+ "\"Cooking_Time\",\"Difficulty_Level\",\"User_Name\") VALUES(?,?,?,?,?,?,?)";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, favourite.getTitle());
			statement.setString(2, favourite.getIngredients());
			statement.setString(3, favourite.getDiscription());
			statement.setString(4, favourite.getAuthor_Name());
			statement.setString(5, favourite.getCooking_Time());
			statement.setString(6, favourite.getDifficulty_Level());
			statement.setString(7, favourite.getUser_Name());
			
			int rows = statement.executeUpdate();
			return rows>0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Favourite> getFavouriteRecipe(String userName) {
		String query = "SELECT * FROM \"Favourite\" WHERE \"User_Name\"=?";
		List<Favourite> favourites = new ArrayList<>();
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, userName);
			
			ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	Favourite favourite = new Favourite();
                
            	favourite.setRecipeID(rs.getInt("Recipe_ID"));
            	favourite.setTitle(rs.getString("Recipe_Title"));
            	favourite.setIngredients(rs.getString("Ingredients"));
                favourite.setDiscription(rs.getString("Description"));
                favourite.setAuthor_Name(rs.getString("Author_Name"));
                favourite.setCooking_Time(rs.getString("Cooking_Time"));
                favourite.setDifficulty_Level(rs.getString("Difficulty_Level"));
                favourite.setUser_Name(rs.getString("User_Name"));
                favourites.add(favourite);
            }
            return favourites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteFavourite(int id) {
		String query = "DELETE FROM \"Favourite\" WHERE \"Recipe_ID\"=?";
		
		try(Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
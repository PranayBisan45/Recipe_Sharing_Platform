package com.codon.model;

public class Recipe {
	private int recipeID;
	private String title;
    private String ingredients;
    private String discription;
    private String User_Name;
    private String Cooking_Time;
    private String Difficulty_Level;
    
	public Recipe() {
		super();
	}
	
	public Recipe(int recipeID, String title, String ingredients, String discription, String user_Name,
			String cooking_Time, String difficulty_Level) {
		super();
		this.recipeID = recipeID;
		this.title = title;
		this.ingredients = ingredients;
		this.discription = discription;
		User_Name = user_Name;
		Cooking_Time = cooking_Time;
		Difficulty_Level = difficulty_Level;
	}

	public Recipe(int recipeID, String title, String ingredients, String discription, String cooking_Time, String difficulty_Level) {
		super();
		this.recipeID = recipeID;
		this.title = title;
		this.ingredients = ingredients;
		this.discription = discription;
		Cooking_Time = cooking_Time;
		Difficulty_Level = difficulty_Level;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getdiscription() {
		return discription;
	}
	public void setdiscription(String discription) {
		this.discription = discription;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getCooking_Time() {
		return Cooking_Time;
	}
	public void setCooking_Time(String cooking_Time) {
		Cooking_Time = cooking_Time;
	}

	public String getDifficulty_Level() {
		return Difficulty_Level;
	}
	public void setDifficulty_Level(String difficulty_Level) {
		Difficulty_Level = difficulty_Level;
	}

	@Override
	public String toString() {
		return "Recipe [recipeID=" + recipeID + ", title=" + title + ", ingredients=" + ingredients + ", discription="
				+ discription + ", User_Name=" + User_Name + ", Cooking_Time=" + Cooking_Time + ", Difficulty_Level="
				+ Difficulty_Level + "]";
	}
}

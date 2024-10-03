package com.codon.model;

public class Favourite {
	private int recipeID;
	private String title;
    private String ingredients;
    private String discription;
    private String Author_Name; 
    private String Cooking_Time;
    private String Difficulty_Level;
    private String User_Name;
    
	public Favourite() {
		super();
	}
	
	public Favourite(int recipeID, String title, String ingredients, String discription, String author_Name,
			String cooking_Time, String difficulty_Level, String user_Name) {
		super();
		this.recipeID = recipeID;
		this.title = title;
		this.ingredients = ingredients;
		this.discription = discription;
		Author_Name = author_Name;
		Cooking_Time = cooking_Time;
		Difficulty_Level = difficulty_Level;
		User_Name = user_Name;
	}

	public Favourite(String title, String ingredients, String discription, String author_Name, String cooking_Time,
			String difficulty_Level, String user_Name) {
		super();
		this.title = title;
		this.ingredients = ingredients;
		this.discription = discription;
		Author_Name = author_Name;
		Cooking_Time = cooking_Time;
		Difficulty_Level = difficulty_Level;
		User_Name = user_Name;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getAuthor_Name() {
		return Author_Name;
	}

	public void setAuthor_Name(String author_Name) {
		Author_Name = author_Name;
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

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	@Override
	public String toString() {
		return "Favourite [recipeID=" + recipeID + ", title=" + title + ", ingredients=" + ingredients
				+ ", discription=" + discription + ", Author_Name=" + Author_Name + ", Cooking_Time=" + Cooking_Time
				+ ", Difficulty_Level=" + Difficulty_Level + ", User_Name=" + User_Name + "]";
	}
}

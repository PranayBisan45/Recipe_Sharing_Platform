package com.codon.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codon.dao.RecipeDao;
import com.codon.model.Recipe;

@WebServlet("/searchRecipe")
public class searchRecipeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();
    
    public searchRecipeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        
        List<Recipe> recipes = RDao.searchRecipe(keyword);
        request.setAttribute("data", recipes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchRecipe.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

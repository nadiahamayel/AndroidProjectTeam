package com.example.androidproject.UserSide;

public class RecipesList {

    private  String Recipes_name;

    public RecipesList(String recipes_name) {
        Recipes_name = recipes_name;
    }

    public static final RecipesList[] recipesList = {
            new RecipesList("waffle"),
            new RecipesList("cookies"),
            new RecipesList("cheesecake"),
            new RecipesList("ban cake"),
            new RecipesList("brownies"),
            new RecipesList("muffins"),
            new RecipesList("cinnamon rolls"),
            new RecipesList("cake"),
            new RecipesList("cookies")
    };

    public String getRecipes_name() {
        return Recipes_name;
    }

    public void setRecipes_name(String recipes_name) {
        Recipes_name = recipes_name;
    }

    @Override
    public String toString() {
        return  Recipes_name ;
    }
}

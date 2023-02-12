package com.example.androidproject;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.Arrays;

public class RecipesModel {

    private String recipe_id;
    private String recipe_name;
    private String recipe_time;
    private String recipe_description ;
    private String  recipe_category;

   private int recipe_img;


    public RecipesModel() {
    }

    public RecipesModel(String recipe_id, String recipe_name, String recipe_time, String recipe_description, String recipe_category) {
        this.recipe_id = recipe_id;
        this.recipe_name = recipe_name;
        this.recipe_time = recipe_time;
        this.recipe_description = recipe_description;
        this.recipe_category = recipe_category;
    }

    public RecipesModel(int recipe_id, String recipe_name, String recipe_time, String recipe_description, String recipe_category) {

        this.recipe_name = recipe_name;
        this.recipe_time = recipe_time;
        this.recipe_description = recipe_description;
        this.recipe_category = recipe_category;
    }

    public RecipesModel(String recipe_name, String recipe_time, String recipe_description, String recipe_category) {
        this.recipe_name = recipe_name;
        this.recipe_time = recipe_time;
        this.recipe_description = recipe_description;
        this.recipe_category = recipe_category;

    }



    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_time() {
        return recipe_time;
    }

    public void setRecipe_time(String recipe_time) {
        this.recipe_time = recipe_time;
    }

    public String getRecipe_description() {
        return recipe_description;
    }

    public void setRecipe_description(String recipe_description) {
        this.recipe_description = recipe_description;
    }

    public String getRecipe_category() {
        return recipe_category;
    }

    public void setRecipe_category(String recipe_category) {
        this.recipe_category = recipe_category;
    }


//    public int getRecipe_img() {
//        return recipe_img;
//    }
//
//    public void setRecipe_img(int recipe_img) {
//        this.recipe_img = recipe_img;
//    }


    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }
    @Override
    public String toString() {
        return "RecipesModel{" +

                ", recipe_name='" + recipe_name + '\'' +
                ", recipe_time='" + recipe_time + '\'' +
                ", recipe_description='" + recipe_description + '\'' +
                ", recipe_category=" + recipe_category +
                '}';
    }
}

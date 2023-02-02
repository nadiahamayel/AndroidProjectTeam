package com.example.androidproject;


public class Recipe {
    public String name;
    public String description;
    public int imageID;

    public static final Recipe[] recipes = {
            new Recipe(R.drawable.bancake,"Pancake", "Fluffy pancake with honey & butter" )
    };

    public Recipe(int imageID, String name, String description){
        this.name = name;
        this.description = description;
        this.imageID = imageID;
    }

    public Recipe(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImage(){
        return imageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    @Override
    public String toString(){return name;}
}
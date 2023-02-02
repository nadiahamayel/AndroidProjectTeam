package com.example.androidproject.Drink;

import com.example.androidproject.R;

public class DrinksList {

    private String drinkName;
    private int drinkImg;

    public static final DrinksList[] drinksList = {
            new DrinksList(  "Coffee" , R.drawable.coffee ),
            new DrinksList("Cappuccino",  R.drawable.coffee),
            new DrinksList("Filter", R.drawable.coffee),
            new DrinksList("Tea", R.drawable.coffee),
            new DrinksList("Mocha", R.drawable.coffee),
            new DrinksList("Ice Coffee", R.drawable.coffee),
            new DrinksList("Ice Tea", R.drawable.coffee),
            new DrinksList("Vanilla", R.drawable.coffee),
            new DrinksList("Americano", R.drawable.coffee)
    };

    public DrinksList(String drinkName, int drinkImg) {
        this.drinkName = drinkName;
        this.drinkImg = drinkImg;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkImg() {
        return drinkImg;
    }

    public void setDrinkImg(int drinkImg) {
        this.drinkImg = drinkImg;
    }

    @Override
    public String toString() {
        return drinkName;
    }
}

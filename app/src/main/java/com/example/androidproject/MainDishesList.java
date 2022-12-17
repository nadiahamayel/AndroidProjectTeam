package com.example.androidproject;

public class MainDishesList {

    private String DishName;
    private int DishImg ;

    public static final MainDishesList[] mainDishes = {
            new MainDishesList("waffle", R.drawable.waffle),
            new MainDishesList("cookies", R.drawable.cookies),
            new MainDishesList("cheesecake", R.drawable.cheesecake),
            new MainDishesList("ban cake", R.drawable.bancake),
            new MainDishesList("brownies", R.drawable.brownies),
            new MainDishesList("muffins", R.drawable.muffins),
            new MainDishesList("cinnamon rolls", R.drawable.cinnamonrolls),
            new MainDishesList("cake", R.drawable.cake),
            new MainDishesList("cookies", R.drawable.cookies),
    };

    public MainDishesList(String dishName, int dishImg) {
        DishName = dishName;
        DishImg = dishImg;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public int getDishImg() {
        return DishImg;
    }

    public void setDishImg(int dishImg) {
        DishImg = dishImg;
    }

    @Override
    public String toString() {
        return "MainDishesList{" +
                "DishName='" + DishName + '\'' +
                ", DishImg=" + DishImg +
                '}';
    }
}

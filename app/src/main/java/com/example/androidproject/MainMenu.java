package com.example.androidproject;

public class MainMenu {
    private int img ;
    private String text;

    public static final MainMenu[] main_menus = {
            new MainMenu( R.drawable.coffee , "Drinks"),
            new MainMenu (R.drawable.person , "Main Dishes"),
            new MainMenu (R.drawable.favorite , "Side Dishes"),
            new MainMenu (R.drawable.home , "Sweets")

    };

    public  MainMenu(int img, String text) {
        this.img = img;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "img=" + img +
                ", text='" + text + '\'' +
                '}';
    }
}

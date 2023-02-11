package com.example.androidproject.MainDish;

import com.example.androidproject.R;

public class MainDishesDet {

    private String mainDishes_name;
    private String mainDishes_description;
    private String mainDishes_time ;
    private int mainDishes_imageID;

    public MainDishesDet() {
    }

    public static final MainDishesDet[] mainDishes = {
            new MainDishesDet(  "Maqluba" , "test Cake","120" , R.drawable.cake ),
            new MainDishesDet("Mansaaf",  "test CheeseCake","150" ,R.drawable.cheesecake),
            new MainDishesDet("BBQ", "test Waffle","90" ,R.drawable.waffle),
            new MainDishesDet("Mlukhyia", "test BanCake","77" ,R.drawable.bancake),
            new MainDishesDet("Pasta", "test Cinnamon rolls","89" ,R.drawable.cinnamonrolls),
            new MainDishesDet("Lazania", "test Muffins","45" ,R.drawable.muffins),
            new MainDishesDet("Mujadara", "test Brownies","30" ,R.drawable.brownies),
            new MainDishesDet("Pizza", "test Cookies","20" ,R.drawable.cookies)
    };

    public MainDishesDet(String mainDishes_name, String mainDishes_description, String mainDishes_time, int mainDishes_imageID) {
        this.mainDishes_name = mainDishes_name;
        this.mainDishes_description = mainDishes_description;
        this.mainDishes_time = mainDishes_time;
        this.mainDishes_imageID = mainDishes_imageID;
    }

    public String getMainDishes_name() {
        return mainDishes_name;
    }

    public void setMainDishes_name(String mainDishes_name) {
        this.mainDishes_name = mainDishes_name;
    }

    public String getMainDishes_description() {
        return mainDishes_description;
    }

    public void setMainDishes_description(String mainDishes_description) {
        this.mainDishes_description = mainDishes_description;
    }

    public String getMainDishes_time() {
        return mainDishes_time;
    }

    public void setMainDishes_time(String mainDishes_time) {
        this.mainDishes_time = mainDishes_time;
    }

    public int getMainDishes_imageID() {
        return mainDishes_imageID;
    }

    public void setMainDishes_imageID(int mainDishes_imageID) {
        this.mainDishes_imageID = mainDishes_imageID;
    }

    @Override
    public String toString() {
        return "MainDishesDet{" +
                "mainDishes_name='" + mainDishes_name + '\'' +
                ", mainDishes_description='" + mainDishes_description + '\'' +
                ", mainDishes_time='" + mainDishes_time + '\'' +
                ", mainDishes_imageID=" + mainDishes_imageID +
                '}';
    }
}

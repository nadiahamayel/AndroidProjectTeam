package com.example.androidproject;

public class DrinkDet {
    private String name;
    private String description;
    private int drink_time ;
    private int imageID;

    public static final DrinkDet[] drinks = {
            new DrinkDet("Coffee", "Some coffee beans with hot water and mix it for 2 min " , 5  , R.drawable.coffee),
            new DrinkDet("Cappuccino", "espresso, hot milk, and steamed milk foam",15 , R.drawable.coffee),
            new DrinkDet("Filter", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Tea", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Mocha", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Ice Coffee", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Ice Tea", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Vanilla", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee),
            new DrinkDet("Americano", "High quality beans roasted and brewed fresh",17 , R.drawable.coffee)

    };

    public DrinkDet(String name, String description, int drink_time, int imageID) {
        this.name = name;
        this.description = description;
        this.drink_time = drink_time;
        this.imageID = imageID;
    }

    public int getTime() {
        return drink_time;
    }
    public void setTime(int time) {
        this.drink_time = time;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getImageID(){return imageID;}

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", drink time=" + drink_time +
                ", imageID=" + imageID +
                '}';
    }
}

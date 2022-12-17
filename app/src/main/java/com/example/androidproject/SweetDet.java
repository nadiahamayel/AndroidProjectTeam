package com.example.androidproject;

public class SweetDet {
    private String sweet_name;
    private String sweet_description;
    private int sweet_time ;
    private int sweet_imageID;

    public static final SweetDet[] sweets = {
            new SweetDet(  "Cake" , "test Cake",60 ,R.drawable.cake ),
            new SweetDet("CheeseCake",  "test CheeseCake",90 ,R.drawable.cheesecake),
            new SweetDet("Waffle", "test Waffle",20 ,R.drawable.waffle),
            new SweetDet("BanCake", "test BanCake",10 ,R.drawable.bancake),
            new SweetDet("Cinnamon rolls", "test Cinnamon rolls",60 ,R.drawable.cinnamonrolls),
            new SweetDet("Muffins", "test Muffins",45 ,R.drawable.muffins),
            new SweetDet("Brownies", "test Brownies",60 ,R.drawable.brownies),
            new SweetDet("Cookies", "test Cookies",40 ,R.drawable.cookies)
    };

    public SweetDet(String sweet_name, String sweet_description, int sweet_time, int sweet_imageID) {
        this.sweet_name = sweet_name;
        this.sweet_description = sweet_description;
        this.sweet_time = sweet_time;
        this.sweet_imageID = sweet_imageID;
    }

    public String getSweet_name() {
        return sweet_name;
    }

    public void setSweet_name(String sweet_name) {
        this.sweet_name = sweet_name;
    }

    public String getSweet_description() {
        return sweet_description;
    }

    public void setSweet_description(String sweet_description) {
        this.sweet_description = sweet_description;
    }

    public int getSweet_time() {
        return sweet_time;
    }

    public void setSweet_time(int sweet_time) {
        this.sweet_time = sweet_time;
    }

    public int getSweet_imageID() {
        return sweet_imageID;
    }

    public void setSweet_imageID(int sweet_imageID) {
        this.sweet_imageID = sweet_imageID;
    }

    @Override
    public String toString() {
        return "SweetDet{" +
                "sweet_name='" + sweet_name + '\'' +
                ", sweet_description='" + sweet_description + '\'' +
                ", sweet_time=" + sweet_time +
                ", sweet_imageID=" + sweet_imageID +
                '}';
    }
}

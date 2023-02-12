package com.example.androidproject.Sweet;

import com.example.androidproject.R;

public class SweetList {

    private String sweetName ;
    private int sweetImg;

    public SweetList() {
    }

    public static final SweetList[] sweetsList = {
            new SweetList(  "Cake" , R.drawable.cake ),
            new SweetList("CheeseCake",  R.drawable.cheesecake),
            new SweetList("Waffle", R.drawable.waffle),
            new SweetList("BanCake", R.drawable.bancake),
            new SweetList("Cinnamon rolls", R.drawable.cinnamonrolls),
            new SweetList("Muffins", R.drawable.muffins),
            new SweetList("Brownies", R.drawable.brownies),
            new SweetList("Cookies", R.drawable.cookies)

    };

    public SweetList(String sweetName, int sweetImg) {
        this.sweetName = sweetName;
        this.sweetImg = sweetImg;
    }

    public String getSweetName() {
        return sweetName;
    }

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public int getSweetImg() {
        return sweetImg;
    }

    public void setSweetImg(int sweetImg) {
        this.sweetImg = sweetImg;
    }

    @Override
    public String toString() {
        return sweetName ;
    }
}

package com.example.androidproject;

public class SideDishes {
    private String sideName;
    private int sideimg;

    public static final SideDishes[] sideDishes = {
            new SideDishes("waffle", R.drawable.waffle),
            new SideDishes("cookies", R.drawable.cookies),
            new SideDishes("cheesecake", R.drawable.cheesecake),
            new SideDishes("ban cake", R.drawable.bancake),
            new SideDishes("brownies", R.drawable.brownies),
            new SideDishes("muffins", R.drawable.muffins),
            new SideDishes("cinnamon rolls", R.drawable.cinnamonrolls),
            new SideDishes("cake", R.drawable.cake),
            new SideDishes("cookies", R.drawable.cookies),
    };

    public SideDishes(String sideName, int sideimg) {
        this.sideName = sideName;
        this.sideimg = sideimg;
    }

    public String getSideName() {
        return sideName;
    }

    public void setSideName(String sideName) {
        this.sideName = sideName;
    }

    public int getSideimg() {
        return sideimg;
    }

    public void setSideimg(int sideimg) {
        this.sideimg = sideimg;
    }

    @Override
    public String toString() {
        return "SideDishesList{" +
                "SideName='" + sideName + '\'' +
                ", SideImg=" + sideimg +
                '}';
    }
}

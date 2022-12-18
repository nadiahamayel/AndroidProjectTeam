package com.example.androidproject;

public class SideDishes {
    private String sideName;
    private int sideimg;

    public static final SideDishes[] sideDishes = {
            new SideDishes("Anchovy", R.drawable.anchovy),
            new SideDishes("Broccoli", R.drawable.broccoli),
            new SideDishes("Broccolinil", R.drawable.broccolini),
            new SideDishes("Caramelised", R.drawable.caramelised),
            new SideDishes("Chunky", R.drawable.chunky),
            new SideDishes("Mexican", R.drawable.mexican),
            new SideDishes("Potato", R.drawable.potato),
            new SideDishes("Rea rice", R.drawable.rice),
            new SideDishes("Roasted", R.drawable.roasted),
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

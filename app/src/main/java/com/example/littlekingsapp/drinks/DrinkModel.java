package com.example.littlekingsapp.drinks;

public class DrinkModel {

    String mDrinkName;
    String mDrinkDetail;
    int mDrinkPhoto;


    // Constructor
    public DrinkModel(String mDrinkName, String mDrinkDetail, int mDrinkPhoto) {
        this.mDrinkName = mDrinkName;
        this.mDrinkDetail = mDrinkDetail;
        this.mDrinkPhoto = mDrinkPhoto;
    }



    //Getter
    public String getmDrinkName() {
        return mDrinkName;
    }

    public String getmDrinkDetail() {
        return mDrinkDetail;
    }

    public int getmDrinkPhoto() {
        return mDrinkPhoto;
    }
}

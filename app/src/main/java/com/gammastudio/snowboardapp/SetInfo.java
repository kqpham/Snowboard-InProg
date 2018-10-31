package com.gammastudio.snowboardapp;

public class SetInfo {

    private String setName;
    private float setBudget;
    private int userSex;
    private float shoeSize;
    private String shirtsize;
    private float pantWidth;
    private float pantLength;
    private String gloveSize;
    public SetInfo() {
    }

    public SetInfo(String setName, float setBudget, int userSex, float shoeSize, String shirtsize, float pantWidth, float pantLength, String gloveSize) {
        this.setName = setName;
        this.setBudget = setBudget;
        this.userSex = userSex;
        this.shoeSize = shoeSize;
        this.shirtsize = shirtsize;
        this.pantWidth = pantWidth;
        this.pantLength = pantLength;
        this.gloveSize = gloveSize;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public float getSetBudget() {
        return setBudget;
    }

    public void setSetBudget(float setBudget) {
        this.setBudget = setBudget;
    }

    public String getUserSex() {
        if(userSex == 1)
        {
            return "Male";
        }
        else{
            return "Female";
        }
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public float getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(float shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShirtsize() {
        return shirtsize;
    }

    public void setShirtsize(String shirtsize) {
        this.shirtsize = shirtsize;
    }

    public float getPantWidth() {
        return pantWidth;
    }

    public void setPantWidth(float pantWidth) {
        this.pantWidth = pantWidth;
    }

    public float getPantLength() {
        return pantLength;
    }

    public void setPantLength(float pantLength) {
        this.pantLength = pantLength;
    }

    public String getGloveSize() {
        return gloveSize;
    }

    public void setGloveSize(String gloveSize) {
        this.gloveSize = gloveSize;
    }
}

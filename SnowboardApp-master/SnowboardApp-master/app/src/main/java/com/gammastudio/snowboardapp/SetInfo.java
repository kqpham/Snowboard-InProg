package com.gammastudio.snowboardapp;

public class SetInfo {

    private String setName;
    private float setBudget;
    public SetInfo() {
    }

    public SetInfo(String setName, float setBudget) {
        this.setName = setName;
        this.setBudget = setBudget;

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


}

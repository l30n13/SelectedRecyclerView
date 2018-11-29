package com.mcc.selectedrecycler;

public class ItemModel {
    int selected, nonSelected;
    String name;

    private boolean categorySelected = false;
    public ItemModel(int selected, int nonSelected, String name, boolean categorySelected) {
        this.selected = selected;
        this.nonSelected = nonSelected;
        this.name = name;
        this.categorySelected=categorySelected;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public boolean isCategorySelected() {
        return categorySelected;
    }

    public void setCategorySelected(boolean categorySelected) {
        this.categorySelected = categorySelected;
    }

    public int getNonSelected() {
        return nonSelected;
    }

    public void setNonSelected(int nonSelected) {
        this.nonSelected = nonSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

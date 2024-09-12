package com.rasion.Demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Card{
    private String size;
    private String color;
    private int num;

    public Card() {
    }

    public Card(String size, String color, int num) {
        this.size = size;
        this.color = color;
        this.num = num;
    }

    @Override
    public String toString() {
        return size+color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

package com.rasion.extendANDpolymorphism.Demo;

public class Card {
    private String carNumber;
    private String ownerName;
    private String ownerPhone;
    private double balance;
    //存储金额
    public void storeMoney(double money) {
        //存储金额
        balance += money;
    }
    //消费金额
    public void consumeMoney(double money) {
        //消费金额
        balance -= money;
    }

    public Card(String carNumber, String ownerName, String ownerPhone, double balance) {
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "carNumber='" + carNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Card() {
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

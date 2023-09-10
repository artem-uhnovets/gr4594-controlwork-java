package model.toy;

import model.toyshop.ToyShopItem;

import java.io.Serializable;
import java.util.Random;

public class Toy implements ToyShopItem<Toy>, Serializable {
    private static int globalID = 0;
    private final int id;
    private String name;                // type of toy
    private int quantity;
    private int winCheck;              // dice to 20

    public Toy(String name) {
        this.name = name;
        this.id = globalID;
        ++globalID;
        this.quantity = 1;
        this.winCheck = setRandomFrequency();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name+":"+" id "+this.id+"\n");
        sb.append(repeat(this.name.length()+1," ")+" количество "+this.quantity+"\n");
        sb.append(repeat(this.name.length()+1," ")+" вероятность выигрыша "+
                                                                ((20.0 - this.winCheck)/20.0)*100.0+"%\n");
        return sb.toString();
    }

    // метод используется в toString
    private String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    private int setRandomFrequency() {
        Random rnd = new Random();
        int max = 20;
        int min = 1;
        return min + rnd.nextInt(max - min + 1);
    }

    public void setWinCheck(int winCheck) {
        this.winCheck = winCheck;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getWinCheck() {
        return this.winCheck;
    }
}

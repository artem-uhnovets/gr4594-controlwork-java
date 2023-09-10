package model.toyshop;

import model.toyshop.iterator.ToyIterator;
import model.toy.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ToyShop<T extends ToyShopItem<T>> implements Serializable, Iterable<T> {
    private List<T> toysList;
    private List<T> prizeToysList;

    public ToyShop() {
        this.toysList = new ArrayList<>();
        this.prizeToysList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T toy:this.toysList) {
            sb.append(String.format("%s \n", toy));
        }
        return sb.substring(0,sb.length()-3);
    }

//    public boolean addToy(T toy) {
//        if (this.toysList == null) {
//            this.toysList = new ArrayList<>();
//        }
//        this.toysList.add(toy);
//        return this.toysList.contains(toy);
//    }

    public boolean addToShop(T toy) {
        if (this.toysList == null) {
            this.toysList = new ArrayList<>();
        }
        boolean isExist = false;
        for (T t : this.toysList) {
            if (t.getName().equalsIgnoreCase(toy.getName())) {
                t.setQuantity(t.getQuantity() + 1);
                isExist = true;
                toy = t;
            }
        }
        if (!isExist) {
            this.toysList.add(toy);
        }
        return this.toysList.contains(toy);
    }

    private T getToyByName(String name) {
        for (T t:this.toysList) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public boolean addToyToPrizeList(String name) {
        if (this.prizeToysList == null) {
            this.prizeToysList = new ArrayList<>();
        }
        T toy = this.getToyByName(name);
        this.prizeToysList.add(toy);
        return this.prizeToysList.contains(toy);
    }

    public void setQuantityByName(String name, int quantity) {
        for (T toy:this.toysList) {
            if (toy.getName().equalsIgnoreCase(name)) {
                toy.setQuantity(quantity);
            }
        }
    }

    public void setWinCheckByName(String name, int winCheck) {
        for (T toy:this.toysList) {
            if (toy.getName().equalsIgnoreCase(name)) {
                toy.setWinCheck(winCheck);
            }
        }
    }

    public boolean giveOutPrize() {
        T toyToGiveOut = this.prizeToysList.remove(0);
        this.setQuantityByName(toyToGiveOut.getName(), toyToGiveOut.getQuantity() - 1);
        return !this.prizeToysList.contains(toyToGiveOut);
    }

    @Override
    public Iterator<T> iterator() {
        return new ToyIterator<>(this.toysList);
    }

    public boolean isEmpty() {
        return this.toysList.isEmpty();
    }

    public boolean isPrizeListEmpty() {
        return this.prizeToysList.isEmpty();
    }

    public int getSize() {
        return this.toysList.size();
    }

    public String getPrizeList() {
        StringBuilder sb = new StringBuilder();
        for (T toy:this.prizeToysList) {
            sb.append(String.format("%s \n", toy));
        }
        return sb.substring(0,sb.length()-3);
    }

    public boolean checkToyInPrizeList(String name) {
        boolean isExist = false;
        if (!this.isPrizeListEmpty()) {
            for (T t : this.prizeToysList) {
                if (t.getName().equalsIgnoreCase(name)) {
                    isExist = true;
                }
            }
        }
        return isExist;
    }

    public boolean checkToyInShop(String name) {
        boolean isExist = false;
        if (!this.isEmpty()) {
            for (T t : this.toysList) {
                if (t.getName().equalsIgnoreCase(name)) {
                    isExist = true;
                }
            }
        }
        return isExist;
    }

    public String getPrizeName() {
        return this.prizeToysList.get(0).getName();
    }

    public int getPrizeWinCheck() {
        return this.prizeToysList.get(0).getWinCheck();
    }

    public int lottery() {
        Random rnd = new Random();
        int max = 20;
        int min = 1;
        return min + rnd.nextInt(max - min + 1);
    }
}

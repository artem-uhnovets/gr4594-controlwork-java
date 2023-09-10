package model.service;

import model.toy.Toy;
import model.toyshop.ToyShop;
import model.toyshop.ToyShopItem;

public class Service<T extends ToyShopItem<T>> {
    private ToyShop<T> shop;

    public Service(ToyShop<T> shop) {
        this.shop = shop;
    }

    public Service() {

    }

    public boolean isShopEmpty() {
        return this.shop.isEmpty();
    }

    public boolean isPrizeListEmpty() {
        return this.shop.isPrizeListEmpty();
    }

    public int getShopSize() {
        return this.shop.getSize();
    }

    public String getShop() {
        return shop.toString();
    }

    public String getPrizeList() {
        return shop.getPrizeList();
    }

    public boolean addToShop(String name) {
        Toy toyToAdd = new Toy(name);
        return shop.addToShop((T) toyToAdd);
    }

    public boolean checkToyInPrizeList(String name) {
        return shop.checkToyInPrizeList(name);
    }

    public boolean addToyToPrizeList(String name) {
        return shop.addToyToPrizeList(name);
    }

    public String getPrizeName() {
        return shop.getPrizeName();
    }

    public int getPrizeWinCheck() {
        return shop.getPrizeWinCheck();
    }

    public int lottery() {
        return shop.lottery();
    }

    public boolean writeToFile(String name) {
        return WriteToFile.save(name);
    }

    public boolean giveOutPrize() {
        return shop.giveOutPrize();
    }

    public boolean checkToyInShop(String name) {
        return shop.checkToyInShop(name);
    }

    public void SetFreqWin(String name, int newWinCheck) {
        shop.setWinCheckByName(name, newWinCheck);
    }

    public void SetQuantity(String name, int newQuantity) {
        shop.setQuantityByName(name, newQuantity);
    }

    public void exit() {
        System.exit(0);
    }
}

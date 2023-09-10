package model.toyshop;

import java.io.Serializable;

public interface ToyShopItem<T> extends Serializable {
    void setWinCheck(int winCheck);
    void setQuantity(int quantity);
    String getName();
    int getQuantity();
    int getWinCheck();
//    T getToyByName();
//    T getToyByName(String name);
}

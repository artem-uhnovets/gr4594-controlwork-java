package presenter;

import model.service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public boolean isShopEmpty() {
        return service.isShopEmpty();
    }

    public boolean isPrizeListEmpty() {
        return service.isPrizeListEmpty();
    }

    public int getShopSize() {
        return service.getShopSize();
    }

    public void getShop() {
        view.repeatLine();
        view.print(service.getShop());
        view.repeatLine();
    }

    public void getPrizeList() {
        view.repeatLine();
        view.print(service.getPrizeList());
        view.repeatLine();
    }

    public boolean addToShop(String name) {
        return service.addToShop(name);
    }

    public boolean checkToyInPrizeList(String name) {
        return service.checkToyInPrizeList(name);
    }

    public boolean addToyToPrizeList(String name) {
        return service.addToyToPrizeList(name);
    }

    public String getPrizeName() {
        return service.getPrizeName();
    }

    public int getPrizeWinCheck() {
        return service.getPrizeWinCheck();
    }

    public int lottery() {
        return service.lottery();
    }

    public Boolean writeToFile(String name) {
        return service.writeToFile(name);
    }

    public Boolean giveOutPrize() {
        return service.giveOutPrize();
    }

    public void SetFreqWin(String name, int newWinCheck) {
        service.SetFreqWin(name, newWinCheck);
    }

    public boolean checkToyInShop(String name) {
        return service.checkToyInShop(name);
    }

    public void SetQuantity(String name, int newQuantity) {
        service.SetQuantity(name, newQuantity);
    }

    public void exit() {
        view.print("Всего доброго!");
        service.exit();
    }
}

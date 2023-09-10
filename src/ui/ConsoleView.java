package ui;

import presenter.Presenter;
import ui.menus.MainMenu;

import java.util.Scanner;

public class ConsoleView implements View{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private static final String inputError = "Ошибка ввода!";

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
        this.menu = new MainMenu(this);
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
        print("Добро пожаловать!");
        while (true) {
            menu.show();
            execute();
        }
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void execute() {
        int option = checkOption("выберите действие -> ", menu.getSize());
        menu.execute(option - 1, "");
    }

    private String scan(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public void repeatLine() {
        System.out.println(new String(new char[60]).replace("\0", "="));
    }

    // возвращает число, если ли строка является числом
    private int checkNum(String numStr) {
        while (!isNum(numStr)) {
            System.out.print(inputError+" - введено не число\nПопробуйте еще раз -> ");
            numStr = scanner.nextLine();
        }
        return Integer.parseInt(numStr);
    }

    // boolean выражение "является ли числом"
    private boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    // проверка выбора действия
    private int checkOption(String textToOutput, int size) {
        int resultOption = checkNum(scan(textToOutput));
        while (!isValidOptionSize(resultOption, size)) {
            print(inputError+"\nВыберите от 1 до "+size);
            resultOption = checkNum(scan(textToOutput));
        }
        return resultOption;
    }

    private Boolean isValidOptionSize(int chosenOption, int optionSize) {
        return chosenOption > 0 && chosenOption <= optionSize;
    }

    // проверка - выполнено ли действие
    private void isDone(Boolean presenterMethod) {
        if (presenterMethod) {
            successMsg();
        } else { failureMsg(); }
    }

    private void successMsg() {
        print("Успешно!");
    }

    private void failureMsg() {
        print("Неудача!");
    }


    public void getAllToys() {
        if (presenter.isShopEmpty()) {
            repeatLine();
            print("В магазине нет игрушек!");
            repeatLine();
        } else {
            presenter.getShop();
        }
    }

    public void getAllPrizeToys() {
        if (presenter.isPrizeListEmpty()) {
            repeatLine();
            print("На розыгрыш игрушек нет");
            repeatLine();
        } else {
            presenter.getPrizeList();
        }
    }

    public void addToShop() {
        String name = scan("Введите наименование игрушки -> ");
        isDone(presenter.addToShop(name));
    }


    public void addToyToPrizeList() {
        String name = scan("Введите наименование игрушки -> ");
        if (presenter.checkToyInPrizeList(name)) {
            print("Введенная игрушка уже в розыгрыше!");
        } else {
            isDone(presenter.addToyToPrizeList(name));
        }
    }

    public void Lottery() {
        if (presenter.isPrizeListEmpty()) {
            repeatLine();
            print("На розыгрыш игрушек нет");
            repeatLine();
        } else {
            print("В розыгрыше:");
            print(presenter.getPrizeName());

            System.out.print("Для выигрыша необходимо выбросить большее или равное число -> ");
            int winCheckNumber = presenter.getPrizeWinCheck();
            print(Integer.toString(winCheckNumber));

            repeatLine();
            System.out.print("Выпало -> ");
            int checkNumber = presenter.lottery();
            print(Integer.toString(checkNumber));
            repeatLine();

            if (checkNumber >= winCheckNumber) {
                presenter.writeToFile(presenter.getPrizeName()+"\n");
                isDone(presenter.giveOutPrize());
            } else {
                print("Неудача, в следующий раз повезет!");
                repeatLine();
            }
        }
    }

    public void SetFreqWin() {
        if (!presenter.isShopEmpty()) {
            String name = scan("Введите наименование игрушки -> ");
            if (presenter.checkToyInShop(name)) {
                int newWinCheck = checkOption("Введите новое значение от 1 до 20 -> ", 20);
                presenter.SetFreqWin(name, newWinCheck);
            } else {
                print("Такой игрушки нет в магазине!");
            }
        } else {
            repeatLine();
            print("В магазине нет игрушек!");
            repeatLine();
        }
    }

    public void SetQuantity() {
        if (!presenter.isShopEmpty()) {
            String name = scan("Введите наименование игрушки -> ");
            if (presenter.checkToyInShop(name)) {
                int newQuantity = checkNum(scan("Введите новое количество -> "));
                presenter.SetQuantity(name, newQuantity);
            } else {
                print("Такой игрушки нет в магазине!");
            }
        } else {
            repeatLine();
            print("В магазине нет игрушек!");
            repeatLine();
        }
    }

    public void exit() {
        presenter.exit();
    }
}

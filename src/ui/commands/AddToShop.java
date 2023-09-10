package ui.commands;

import ui.ConsoleView;

public class AddToShop extends Command {
    public AddToShop(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить игрушку в магазин";
    }

    @Override
    public void execute(String text) {
        consoleView.addToShop();
    }
}

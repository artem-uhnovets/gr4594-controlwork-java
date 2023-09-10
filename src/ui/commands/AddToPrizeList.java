package ui.commands;

import ui.ConsoleView;

public class AddToPrizeList extends Command {
    public AddToPrizeList(ConsoleView consoleView) {
        super(consoleView);
        description = "Добавить игрушку в розыгрыш";
    }

    @Override
    public void execute(String text) {
        consoleView.addToyToPrizeList();
    }
}

package ui.commands;

import ui.ConsoleView;

public class OutputConsolePrizeToys extends Command {
    public OutputConsolePrizeToys(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести все игрушки на розыгрыше";
    }

    @Override
    public void execute(String text) {
        consoleView.getAllPrizeToys();
    }
}

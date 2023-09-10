package ui.commands;

import ui.ConsoleView;

public class OutputConsole extends Command {

    public OutputConsole(ConsoleView consoleView) {
        super(consoleView);
        description = "Вывести все игрушки";
    }

    @Override
    public void execute(String text) {
        consoleView.getAllToys();
    }
}
